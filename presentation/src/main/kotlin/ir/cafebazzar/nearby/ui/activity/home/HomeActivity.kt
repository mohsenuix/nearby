package ir.cafebazzar.nearby.ui.activity.home

import android.Manifest
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import ir.cafebazzar.nearby.ui.activity.home.venueviewholder.VenueRecyclerView
import ir.cafebazzar.nearby.ui.base.BaseDaggerActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject
import javax.inject.Provider
import androidx.recyclerview.widget.RecyclerView
import ir.cafebazzar.nearby.util.EndlessRecyclerViewScrollListener
import timber.log.Timber
import com.google.android.gms.location.LocationRequest
import com.patloew.rxlocation.RxLocation
import com.tbruyelle.rxpermissions2.RxPermissions
import android.annotation.SuppressLint
import android.content.Intent
import android.location.Location
import ir.cafebazzar.nearby.ui.activity.detail.DetailActivity
import ir.cafebazzar.nearby.util.distance

class HomeActivity : BaseDaggerActivity<HomeViewState, HomeViewModel>() {
    @Inject
    lateinit var venueAdapterProvider: Provider<VenueRecyclerView>
    lateinit var venueAdapter: VenueRecyclerView
    private val rxPermissions = RxPermissions(this)
    var lastLocation: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ir.cafebazzar.nearby.R.layout.activity_home)
        createViewModel(HomeViewModel::class.java)
        initRV()
        initRXLocation()
    }


    @SuppressLint("MissingPermission")//it is ok just IDE not support rxPermissions
    private fun initRXLocation() {
        // Create one instance and share it
        val rxLocation = RxLocation(this)
        val locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_LOW_POWER)
                .setInterval(15000)
        val disposable = rxPermissions
                .request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe { granted ->
                    if (granted) { // Always true pre-M
                        val locationDisposable=rxLocation.location().updates(locationRequest)
                                .subscribe { location ->
                                    Timber.i("location is ${location.latitude} ," +
                                            "${location.longitude}")
                                    Timber.i("location is distance to " +
                                            "${lastLocation?.distance(location)}")
                                    if (lastLocation!=null &&
                                            lastLocation!!.distance(location) > .1) {
                                        viewModel.updateLocation(location)
                                    }
                                    lastLocation = location
                                }
                        compositDesposable.add(locationDisposable)

                    } else {

                        //todo show error
                    }
                }
        compositDesposable.add(disposable)

    }

    private fun initRV() {
        venueAdapter = venueAdapterProvider.get()
        recyclerView.adapter = venueAdapter
        val gridLayoutManager = GridLayoutManager(this, 1)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.addOnScrollListener(object : EndlessRecyclerViewScrollListener(gridLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                //todo load more
            }
        })
        val disposable = venueAdapter.mClickPS
                .subscribe { action ->
                    Timber.i("clicked-- ${action.adapterPosition}")
                    startActivity(Intent(this@HomeActivity,DetailActivity::class.java))
                }
        compositDesposable.add(disposable)
    }

    override fun handleState(state: HomeViewState) {
        venueAdapter.submitList(state.venues)
    }
}