package ir.cafebazzar.app.ui.activity.detail

import android.os.Bundle
import ir.cafebazzar.app.ui.base.BaseDaggerActivity

class DetailActivity : BaseDaggerActivity<DetailActivityViewState,DetailActivityViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun handleState(state: DetailActivityViewState) {

    }
}