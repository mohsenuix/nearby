package ir.cafebazzar.app.ui.activity.home

import android.Manifest
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import ir.cafebazzar.app.ui.activity.home.venueviewholder.VenueRecyclerView
import ir.cafebazzar.app.ui.base.BaseDaggerActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject
import javax.inject.Provider
import androidx.recyclerview.widget.RecyclerView
import ir.cafebazzar.app.util.EndlessRecyclerViewScrollListener
import timber.log.Timber
import com.google.android.gms.location.LocationRequest
import com.patloew.rxlocation.RxLocation
import com.tbruyelle.rxpermissions2.RxPermissions
import android.annotation.SuppressLint
import android.location.Location


class HomeActivity : BaseDaggerActivity<HomeViewState, HomeViewModel>() {
    @Inject
    lateinit var venueAdapterProvider: Provider<VenueRecyclerView>
    lateinit var venueAdapter: VenueRecyclerView
    val rxPermissions = RxPermissions(this)
    var lastLocation: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ir.cafebazzar.nearby.R.layout.activity_home)
        createViewModel(HomeViewModel::class.java)
        initRV()
        initRXLocation()
    }

    @SuppressLint("MissingPermission")
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
                        rxLocation.location().updates(locationRequest)
                                .subscribe { location ->
                                    Timber.i("location is ${location.latitude} ," +
                                            "${location.longitude}")
                                    Timber.i("location is distance to " +
                                            "${lastLocation?.distanceTo(location)}")
                                    if (lastLocation!=null &&
                                            lastLocation!!.distanceTo(location) > .1) {
                                        viewModel.updateLocation(location)
                                    }
                                    lastLocation = location
                                }

                    } else {

                        //todo show error
                    }
                }

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
    }

    override fun handleState(state: HomeViewState) {
        venueAdapter.submitList(state.venues)
    }
}