package ir.cafebazzar.nearby.di.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.cafebazzar.nearby.ui.activity.detail.DetailActivity
import ir.cafebazzar.nearby.ui.activity.detail.DetailActivityModule
import ir.cafebazzar.nearby.ui.activity.home.HomeActivity
import ir.cafebazzar.nearby.ui.activity.home.HomeActivityModule

@Module()
abstract class BuilderModule {

//    todo add activity scope
    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [DetailActivityModule::class])
    abstract fun bindDetailActivity(): DetailActivity

}