package ir.cafebazzar.app.ui.activity.home

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import ir.cafebazzar.app.ui.activity.home.venueviewholder.VenueRecyclerView
import ir.cafebazzar.app.ui.base.BaseDaggerActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject
import javax.inject.Provider
import androidx.recyclerview.widget.RecyclerView
import ir.cafebazzar.app.util.EndlessRecyclerViewScrollListener
import ir.cafebazzar.nearby.R
import timber.log.Timber


class HomeActivity: BaseDaggerActivity<HomeViewState, HomeViewModel>() {
    @Inject
    lateinit var venueAdapterProvider : Provider<VenueRecyclerView>
    lateinit var venueAdapter : VenueRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        createViewModel(HomeViewModel::class.java)
        initRV()
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