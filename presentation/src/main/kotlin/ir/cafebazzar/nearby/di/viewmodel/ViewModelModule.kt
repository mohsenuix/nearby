package ir.cafebazzar.nearby.di.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ir.cafebazzar.nearby.ui.activity.detail.DetailActivityViewModel
import ir.cafebazzar.nearby.ui.activity.home.HomeViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(clazz = HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(clazz = DetailActivityViewModel::class)
    abstract fun bindDetailViewModel(viewModel: DetailActivityViewModel): ViewModel

}
