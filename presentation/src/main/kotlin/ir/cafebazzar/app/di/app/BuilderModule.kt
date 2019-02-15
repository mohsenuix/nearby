package ir.cafebazzar.app.di.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.cafebazzar.app.ui.activity.home.HomeActivity
import ir.cafebazzar.app.ui.activity.home.HomeActivityModule
import javax.inject.Singleton

@Module()
abstract class BuilderModule {
    @Singleton
    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun bindHomeActivity(): HomeActivity

}