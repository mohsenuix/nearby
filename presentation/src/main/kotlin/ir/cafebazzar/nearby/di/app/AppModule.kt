package ir.cafebazzar.nearby.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import ir.cafebazzar.nearby.App
import ir.cafebazzar.nearby.data.extractor.NetworkJobExecutor
import ir.cafebazzar.nearby.domain.ForApplication
import ir.cafebazzar.nearby.domain.executor.PostExecutionThread
import ir.cafebazzar.nearby.domain.executor.UseCaseExecutor
import ir.cafebazzar.nearby.domain.repository.ConnectivityManager
import ir.cafebazzar.nearby.nearby.BuildConfig
import ir.cafebazzar.nearby.ui.UiThreadExecutor
import ir.cafebazzar.nearby.util.ConnectivityManagerImp
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideUseCaseExecutor(): UseCaseExecutor {
        return NetworkJobExecutor()
    }

    @Provides
    @Singleton
    fun postExecutionThread(): PostExecutionThread = UiThreadExecutor()


    /**
     * there is a bug that BuildConfig.DEBUG is unknown in other modules
     * so we inject this flag to other modules.
     */
    @Provides
    @Singleton
    @Named("isMock")
    fun isMock(): Boolean = BuildConfig.DEBUG

    @Provides
    @ForApplication
    fun provideContext(app: App): Context = app.applicationContext


    @Provides
    @Singleton
    fun provideConnectivityManager(connectivityManagerImp: ConnectivityManagerImp)
            : ConnectivityManager = connectivityManagerImp

}