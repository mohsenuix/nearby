package ir.cafebazzar.app.di.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.cafebazzar.app.ui.activity.detail.DetailActivity
import ir.cafebazzar.app.ui.activity.detail.DetailActivityModule
import ir.cafebazzar.app.ui.activity.home.HomeActivity
import ir.cafebazzar.app.ui.activity.home.HomeActivityModule
import javax.inject.Singleton

@Module()
abstract class BuilderModule {

//    todo add activity scope
    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [DetailActivityModule::class])
    abstract fun bindDetailActivity(): DetailActivity

}