package es.ocado.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dispatch.core.DispatcherProvider
import es.ocado.base.androidtest.BaseTest.Companion.MOCK_WEB_SERVER_PORT
import es.ocado.base.androidtest.BaseTest.Companion.testDispatcherProvider
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationModuleTest {

    @Singleton
    @Provides
    @Named("LOGGABLE")
    fun provideLoggable(): Boolean = true

    @Provides
    @Named("BASE_URL")
    fun provideBaseUrl(): String = "http://localhost:$MOCK_WEB_SERVER_PORT"

    @Singleton
    @Provides
    fun provideDispatchers(): DispatcherProvider = testDispatcherProvider
}
