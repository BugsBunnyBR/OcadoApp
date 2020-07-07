package es.ocado.features.product.list.domain

import dispatch.core.DispatcherProvider
import es.ocado.features.product.list.data.ProductClustersService
import es.ocado.features.product.list.data.model.ProductClusterResponse
import es.ocado.features.product.list.data.model.ProductResponse
import es.ocado.features.product.list.domain.model.ProductClusterEntity
import es.ocado.features.product.list.domain.model.ProductEntity
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal interface GetProducts {
    suspend operator fun invoke(): List<ProductClusterEntity>
}

internal class GetProductsImpl @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val service: ProductClustersService
) : GetProducts {
    override suspend operator fun invoke(): List<ProductClusterEntity> {
        return withContext(dispatchers.io) {
            service.listProducts()
                .clusters
                .map { it.toEntity() }
        }
    }
}

private fun ProductClusterResponse.toEntity(): ProductClusterEntity {
    return ProductClusterEntity(
        tag = tag,
        items = items.map { it.toEntity() }
    )
}

private fun ProductResponse.toEntity(): ProductEntity {
    return ProductEntity(
        id = id,
        title = title,
        size = size,
        price = price,
        imageUrl = imageUrl
    )
}
