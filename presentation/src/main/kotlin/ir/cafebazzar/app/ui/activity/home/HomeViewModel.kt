package ir.cafebazzar.app.ui.activity.home

import ir.cafebazzar.app.domain.entity.LatLng
import ir.cafebazzar.app.domain.interactor.forsquare.GetNearby
import ir.cafebazzar.app.ui.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class HomeViewModel
@Inject constructor(val getNearby: GetNearby)
    : BaseViewModel<HomeViewState>() {


    fun getNearbies(){
        getNearby.execute(LatLng(25.0,3.0)).subscribe { emit->
            Timber.i("emitter size is"+emit.size)

        }
    }
}