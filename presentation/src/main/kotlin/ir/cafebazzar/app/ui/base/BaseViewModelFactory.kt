package ir.cafebazzar.app.ui.base

import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import androidx.lifecycle.ViewModelProvider


abstract class BaseViewModelFactory<S : BaseViewState> : ViewModelProvider.Factory {
    protected var mDisposables: CompositeDisposable = CompositeDisposable()

    protected val mToastLiveData: SingleLiveData<Int> = SingleLiveData()
    protected val mStateLD: MutableLiveData<S> = MutableLiveData()

}