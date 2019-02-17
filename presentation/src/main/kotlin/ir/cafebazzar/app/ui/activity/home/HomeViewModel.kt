package ir.cafebazzar.app.ui.activity.home

import android.location.Location
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

    //40.7484,-73.9857
    fun getNearbies(){
        val disposable = getNearby.execute(LatLng(40.7484,-73.9857)).subscribe({ venues->
            Timber.i("emitter size is"+venues.size)
            stateLD.postValue(HomeViewState(venues))
        },{t: Throwable? ->
            Timber.e(t)
        })
        compositeDisposable.add(disposable)
    }

    fun updateLocation(location: Location?) {

    }
}