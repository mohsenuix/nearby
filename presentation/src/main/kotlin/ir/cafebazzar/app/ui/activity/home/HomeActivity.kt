package ir.cafebazzar.app.ui.activity.home

import android.os.Bundle
import ir.cafebazzar.app.ui.base.BaseDaggerActivity
import ir.cafebazzar.nearby.R

class HomeActivity: BaseDaggerActivity<HomeViewState, HomeViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        createViewModel(HomeViewModel::class.java)
    }

    override fun handleState(state: HomeViewState) {

    }

}