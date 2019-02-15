package ir.cafebazzar.app

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ir.cafebazzar.app.di.app.DaggerAppComponent

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}