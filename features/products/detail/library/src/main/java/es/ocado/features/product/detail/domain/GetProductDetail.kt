package es.ocado.features.product.detail.domain

import dispatch.core.DispatcherProvider
import es.ocado.features.product.detail.data.ProductDetailResponse
import es.ocado.features.product.detail.data.ProductDetailService
import es.ocado.features.product.detail.domain.model.ProductDetailEntity
import es.ocado.features.product.detail.domain.model.ProductDetailId
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal interface GetProductDetail {
    suspend operator fun invoke(id: ProductDetailId): ProductDetailEntity
}

internal class GetProductDetailImpl @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val service: ProductDetailService
) : GetProductDetail {
    override suspend fun invoke(id: ProductDetailId): ProductDetailEntity {
        return withContext(dispatchers.io) {
            service.getProductDetail(id).toEntity()
        }
    }
}

private fun ProductDetailResponse.toEntity(): ProductDetailEntity {
    return ProductDetailEntity(
        id = id,
        title = title,
        price = price,
        imageUrl = imageUrl,
        allergyInformation = allergyInformation,
        description = description
    )
}
