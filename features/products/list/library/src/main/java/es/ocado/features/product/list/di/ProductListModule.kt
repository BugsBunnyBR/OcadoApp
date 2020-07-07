package es.ocado.features.product.list.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import es.ocado.features.product.list.data.ProductClustersService
import es.ocado.features.product.list.domain.GetProducts
import es.ocado.features.product.list.domain.GetProductsImpl
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(ActivityRetainedComponent::class)
internal class ProductListModule {

    @ActivityRetainedScoped
    @Provides
    fun provideService(retrofit: Retrofit): ProductClustersService = retrofit.create()

    @ActivityRetainedScoped
    @Provides
    fun provideGetProducts(impl: GetProductsImpl): GetProducts = impl
}
