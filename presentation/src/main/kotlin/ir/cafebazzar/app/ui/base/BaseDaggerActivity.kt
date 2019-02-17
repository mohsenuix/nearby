package ir.cafebazzar.app.ui.base

import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import io.reactivex.disposables.CompositeDisposable
import ir.cafebazzar.app.di.viewmodel.ViewModelFactory


abstract class BaseDaggerActivity<S:BaseViewState,VM:BaseViewModel<S>> :DaggerAppCompatActivity() {

    @Inject
    @JvmField
    var viewModelFactory: ViewModelFactory?=null
    val clicksCompositDeposable: CompositeDisposable = CompositeDisposable()


    protected lateinit var viewModel: VM

    override fun onStart() {
        super.onStart()
        startObserving()
    }

    override fun onStop() {
        clicksCompositDeposable.clear()
        super.onStop()
    }


    fun createViewModel(clazz: Class<VM>) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(clazz)
    }


    fun showToast(@StringRes string: Int) {
        if (string != 0)
            Toast.makeText(applicationContext, getString(string), Toast.LENGTH_LONG).show()
    }


    private fun startObserving() {
        viewModel.stateLD.observe(this, Observer { state-> handleState(state) })
    }

    abstract fun handleState(state: S)

}
