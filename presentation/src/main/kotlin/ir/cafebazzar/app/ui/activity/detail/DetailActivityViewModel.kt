package ir.cafebazzar.app.ui.activity.detail

import ir.cafebazzar.app.domain.interactor.forsquare.GetVenueDetail
import ir.cafebazzar.app.ui.base.BaseViewModel
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

        })
    }

}