package ir.cafebazzar.app.di.app

import dagger.Module
import dagger.Provides
import ir.cafebazzar.app.data.extractor.NetworkJobExecutor
import ir.cafebazzar.app.domain.executor.PostExecutionThread
import ir.cafebazzar.app.domain.executor.UseCaseExecutor
import ir.cafebazzar.app.nearby.BuildConfig
import ir.cafebazzar.app.ui.UiThreadExecutor
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [BuilderModule::class])
class AppModule{
    @Provides
    @Singleton
    fun provideUseCaseExecutor(): UseCaseExecutor {
        return NetworkJobExecutor()
    }

    @Provides
    @Singleton
    fun postExecutionThread(): PostExecutionThread {
        return UiThreadExecutor()
    }


    /**
     * there is a bug that BuldConfig.DEBUG is unknown in others module
     * so we inject this flag to other modules.
     */
    @Provides
    @Singleton
    @Named("isMock")
    fun isMock():Boolean = BuildConfig.DEBUG
}