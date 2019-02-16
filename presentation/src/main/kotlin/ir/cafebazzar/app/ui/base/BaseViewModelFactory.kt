package ir.cafebazzar.app.ui.base

import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import androidx.lifecycle.ViewModelProvider


abstract class BaseViewModelFactory<S : BaseViewState>
protected constructor()
    : ViewModelProvider.Factory {

//    @Inject
//    protected var mDisposables: CompositeDisposable? = null

    protected val mToastLiveData: SingleLiveData<Int> = SingleLiveData()
    protected val mStateLD: MutableLiveData<S> = MutableLiveData()

}
