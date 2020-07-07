package es.ocado.features.product.list.data.model

import es.ocado.features.product.list.domain.model.ProductId

internal data class ProductClustersContainerResponse(val clusters: List<ProductClusterResponse>)
internal data class ProductClusterResponse(val tag: String, val items: List<ProductResponse>)

internal data class ProductResponse(
    val id: ProductId,
    val price: String,
    val title: String,
    val size: String,
    val imageUrl: String
)
