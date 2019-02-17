package ir.cafebazzar.nearby.ui.activity.detail

import ir.cafebazzar.nearby.domain.interactor.forsquare.GetVenueDetail
import ir.cafebazzar.nearby.ui.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class DetailActivityViewModel
@Inject constructor(val getVenueDetail: GetVenueDetail)
    : BaseViewModel<DetailActivityViewState>(){
    init {
        getVenueDetail()
    }

    fun getVenueDetail(){
        val disposable = getVenueDetail.execute("4bcca12bb6c49c7422169491")
                .subscribe({

        },{

            Timber.e(it)
        })
    }

}