package es.ocado.features.product.detail.data

import es.ocado.features.product.detail.domain.model.ProductDetailId
import retrofit2.http.GET
import retrofit2.http.Path

internal interface ProductDetailService {

    @GET("product/{id}")
    suspend fun getProductDetail(@Path("id") id: ProductDetailId): ProductDetailResponse
}

internal data class ProductDetailResponse(
    val id: ProductDetailId,
    val price: String,
    val title: String,
    val imageUrl: String,
    val description: String,
    val allergyInformation: String
)
