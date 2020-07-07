package es.ocado.features.product.detail.domain.model

data class ProductDetailEntity(
    val id: ProductDetailId,
    val price: String,
    val title: String,
    val imageUrl: String,
    val description: String,
    val allergyInformation: String
)
