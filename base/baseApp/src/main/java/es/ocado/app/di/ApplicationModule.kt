package es.ocado.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dispatch.core.DefaultDispatcherProvider
import dispatch.core.DispatcherProvider
import es.ocado.app.BuildConfig
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Singleton
    @Provides
    @Named("LOGGABLE")
    fun provideLoggable(): Boolean = BuildConfig.DEBUG

    @Singleton
    @Provides
    @Named("BASE_URL")
    fun provideBaseUrl(): String =
        "https://my-json-server.typicode.com/ocadotechnology/mobile-challenge/"

    @Singleton
    @Provides
    fun provideDispatchers(): DispatcherProvider = DefaultDispatcherProvider()
}
