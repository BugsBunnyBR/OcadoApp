package es.ocado.features.product.detail.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import es.ocado.features.product.detail.data.ProductDetailService
import es.ocado.features.product.detail.domain.GetProductDetail
import es.ocado.features.product.detail.domain.GetProductDetailImpl
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(ActivityRetainedComponent::class)
internal class ProductDetailModule {

    @Provides
    @ActivityRetainedScoped
    fun provideDetailService(retrofit: Retrofit): ProductDetailService = retrofit.create()

    @Provides
    @ActivityRetainedScoped
    fun provideGetProductDetail(impl: GetProductDetailImpl): GetProductDetail = impl
}
