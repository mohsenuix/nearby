package ir.cafebazzar.app

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Component
import dagger.Provides
import ir.cafebazzar.app.nearby.BuildConfig
import javax.inject.Named
import javax.inject.Singleton

@Component(modules = [AppModule::class])
abstract class AppComponent
//(var app: App)
{
//    @Provides
//    @Singleton
//    fun provideApplication(): Application {
//        return app
//    }
//
////    @Provides
////    @Singleton
////    @ForApplication
////    fun provideContext(): Context {
////        return app.applicationContext
////    }
//
////    @Provides
////    @Singleton
////    fun provideResources(@ForApplication context: Context): Resources {
////        return context.resources
////    }
//
////    @Provides
////    @Singleton
////    fun provideUseCaseExecutor(): UseCaseExecutor {
////        return NetworkJobExecutor()
////    }
////
////    @Provides
////    @Singleton
////    fun postExecutionThread(): PostExecutionThread {
////        return MainThreadExecutor()
////    }
//
//
//    @Provides
//    @Singleton
//    @Named("isMock")
//    fun isMock():Boolean = BuildConfig.DEBUG
}