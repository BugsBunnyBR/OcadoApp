package es.ocado.features.product.detail.domain

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import dispatch.test.TestDispatcherProvider
import es.ocado.features.product.detail.data.ProductDetailResponse
import es.ocado.features.product.detail.data.ProductDetailService
import es.ocado.features.product.detail.domain.model.ProductDetailEntity
import es.ocado.features.product.detail.domain.model.ProductDetailId
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class GetProductDetailImplTest {

    val service: ProductDetailService = mock()

    @Test
    fun `should load product details successfully`() {
        val id = ProductDetailId("id")
        val response = ProductDetailResponse(
            id = id,
            description = "description",
            allergyInformation = "allergyInformation",
            imageUrl = "imageUrl",
            price = "price",
            title = "title"
        )
        val expected = ProductDetailEntity(
            id = id,
            description = "description",
            allergyInformation = "allergyInformation",
            imageUrl = "imageUrl",
            price = "price",
            title = "title"
        )
        val getProductDetail = GetProductDetailImpl(TestDispatcherProvider(), service)
        val detail = runBlocking {
            whenever(service.getProductDetail(id)).thenReturn(response)
            getProductDetail(id)
        }
        Assertions.assertEquals(expected, detail)
    }
}
