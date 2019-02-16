package ir.cafebazzar.app.ui.activity.home

import ir.cafebazzar.app.domain.entity.LatLng
import ir.cafebazzar.app.domain.interactor.forsquare.GetNearby
import ir.cafebazzar.app.ui.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class HomeViewModel
@Inject constructor(val getNearby: GetNearby)
    : BaseViewModel<HomeViewState>() {
init {
    getNearbies()
}

    //44.3,37.2
    fun getNearbies(){
        getNearby.execute(LatLng(44.3,37.2)).subscribe({ venues->
            Timber.i("emitter size is"+venues.size)
            stateLD.postValue(HomeViewState(venues))
        },{t: Throwable? ->
            Timber.e(t)
        })
    }
}