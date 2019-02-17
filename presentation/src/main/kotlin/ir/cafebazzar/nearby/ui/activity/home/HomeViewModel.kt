package ir.cafebazzar.nearby.ui.activity.home

import android.location.Location
import ir.cafebazzar.nearby.domain.entity.LatLng
import ir.cafebazzar.nearby.domain.interactor.forsquare.GetNearbyVenues
import ir.cafebazzar.nearby.ui.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class HomeViewModel
@Inject constructor(val getNearbyVenues: GetNearbyVenues)
    : BaseViewModel<HomeViewState>() {
init {
    getNearbies()
}

    //40.7484,-73.9857
    fun getNearbies(){
        val disposable = getNearbyVenues.execute(LatLng(40.7484,-73.9857)).subscribe({ venues->
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