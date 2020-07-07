package es.ocado.features.product.list.domain.model

internal data class ProductClusterEntity(val tag: String, val items: List<ProductEntity>)

data class ProductEntity(
    val id: ProductId,
    val price: String,
    val title: String,
    val size: String,
    val imageUrl: String
)
