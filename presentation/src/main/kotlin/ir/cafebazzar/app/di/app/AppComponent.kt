package ir.cafebazzar.app.di.app

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ir.cafebazzar.app.App
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent

    }

    override fun inject(app: App)
}