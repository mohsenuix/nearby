package ir.cafebazzar.nearby.di.viewmodel


import javax.inject.Inject
import javax.inject.Singleton
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Provider

@Singleton
class ViewModelFactory @Inject constructor() : ViewModelProvider.Factory {

    @Inject
    @JvmField
    var mViewModelProviders: Map<Class<out ViewModel>,
            @JvmSuppressWildcards Provider<ViewModel>>? = null

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return mViewModelProviders!!.getValue(modelClass).get() as T
    }
}
