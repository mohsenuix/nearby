package ir.cafebazzar.app.di.viewmodel


import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Singleton
class ViewModelFactory @Inject
internal constructor() : ViewModelProvider.Factory {

    @Inject
    internal var mViewModelProviders: Map<Class<out ViewModel>, Provider<ViewModel>>? = null

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return mViewModelProviders!!.getValue(modelClass).get() as T
    }
}
