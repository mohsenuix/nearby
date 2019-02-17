package ir.cafebazzar.app.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import ir.cafebazzar.app.App
import ir.cafebazzar.app.data.extractor.NetworkJobExecutor
import ir.cafebazzar.app.data.repository.DataLayerLayerRepositoryImp
import ir.cafebazzar.app.domain.ForApplication
import ir.cafebazzar.app.domain.executor.PostExecutionThread
import ir.cafebazzar.app.domain.executor.UseCaseExecutor
import ir.cafebazzar.app.domain.repository.ConnectivityManager
import ir.cafebazzar.app.domain.repository.DataLayerRepository
import ir.cafebazzar.app.nearby.BuildConfig
import ir.cafebazzar.app.ui.UiThreadExecutor
import ir.cafebazzar.app.util.ConnectivityManagerImp
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
     * there is a bug that BuildConfig.DEBUG is unknown in others module
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