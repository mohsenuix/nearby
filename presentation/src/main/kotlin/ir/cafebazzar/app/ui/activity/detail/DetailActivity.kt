package ir.cafebazzar.app.ui.activity.detail

import android.os.Bundle
import ir.cafebazzar.app.ui.activity.home.HomeViewModel
import ir.cafebazzar.app.ui.base.BaseDaggerActivity
import ir.cafebazzar.nearby.R

class DetailActivity : BaseDaggerActivity<DetailActivityViewState,DetailActivityViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createViewModel(DetailActivityViewModel::class.java)
        setContentView(R.layout.activity_detail)
    }

    override fun handleState(state: DetailActivityViewState) {

    }
}