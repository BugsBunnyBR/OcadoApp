package es.ocado.features.product.list.data

import es.ocado.features.product.list.data.model.ProductClustersContainerResponse
import retrofit2.http.GET

internal interface ProductClustersService {

    @GET("products")
    suspend fun listProducts(): ProductClustersContainerResponse
}
