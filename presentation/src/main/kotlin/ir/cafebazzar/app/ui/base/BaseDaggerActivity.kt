package ir.cafebazzar.app.ui.base

import dagger.android.support.DaggerAppCompatActivity
import ir.cafebazzar.app.di.viewmodel.ViewModelFactory
import javax.inject.Inject
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders


abstract class BaseDaggerActivity<S:BaseViewState,VM:BaseViewModel<S>> :DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory:ViewModelFactory

    protected lateinit var viewModel: VM

    fun createViewModel(clazz: Class<VM>) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(clazz)
    }


    fun showToast(@StringRes string: Int) {
        if (string != 0)
            Toast.makeText(applicationContext, getString(string), Toast.LENGTH_LONG).show()
    }


    fun startObserving() {
        viewModel.stateLD.observe(this, Observer { state-> handleState(state) })
    }

    abstract fun handleState(state: S)

}
