package ir.cafebazzar.nearby.di.app

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ir.cafebazzar.nearby.App
import ir.cafebazzar.nearby.data.DataLayerModule
import ir.cafebazzar.nearby.di.viewmodel.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
    AndroidSupportInjectionModule::class,
    BuilderModule::class, ViewModelModule::class,
    DataLayerModule::class])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent

    }

    override fun inject(app: App)
}