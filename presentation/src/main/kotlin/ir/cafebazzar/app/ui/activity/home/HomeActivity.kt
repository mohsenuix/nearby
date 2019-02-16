package ir.cafebazzar.app.ui.activity.home

import android.os.Bundle
import ir.cafebazzar.app.ui.activity.home.venueviewholder.VenueRecyclerView
import ir.cafebazzar.app.ui.base.BaseDaggerActivity
import ir.cafebazzar.nearby.R
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject
import javax.inject.Provider

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

    }

    override fun handleState(state: HomeViewState) {

    }

}