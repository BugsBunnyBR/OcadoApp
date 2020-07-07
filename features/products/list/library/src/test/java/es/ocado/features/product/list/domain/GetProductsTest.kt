package es.ocado.features.product.list.domain

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import dispatch.test.TestDispatcherProvider
import es.ocado.features.product.list.domain.model.ProductId
import es.ocado.features.product.list.data.ProductClustersService
import es.ocado.features.product.list.data.model.ProductClusterResponse
import es.ocado.features.product.list.data.model.ProductClustersContainerResponse
import es.ocado.features.product.list.data.model.ProductResponse
import es.ocado.features.product.list.domain.model.ProductClusterEntity
import es.ocado.features.product.list.domain.model.ProductEntity
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class GetProductsTest {
    @Test
    fun `should throw error when the service access fails`() {
        // Given
        val service = mock<ProductClustersService>()
        val getProducts = GetProductsImpl(TestDispatcherProvider(), service)
        // then
        assertThrows<Exception> {
            // when
            runBlocking {
                whenever(service.listProducts()).thenThrow(Exception())
                getProducts()
            }
        }
    }

    @Test
    fun `should retrieve product clusters from service`() {
        // Given
        val service = mock<ProductClustersService>()
        val clusterResponse = ProductClusterResponse(
            tag = "tag",
            items = listOf(
                ProductResponse(
                    id = ProductId("id"),
                    imageUrl = "imageUrl",
                    price = "price",
                    size = "size",
                    title = "title"
                )
            )
        )
        val expected = listOf(
            ProductClusterEntity(
                tag = "tag",
                items = listOf(
                    ProductEntity(
                        id = ProductId(
                            "id"
                        ),
                        imageUrl = "imageUrl",
                        price = "price",
                        size = "size",
                        title = "title"
                    )
                )
            )
        )
        val response = ProductClustersContainerResponse(listOf(clusterResponse))
        val getProducts = GetProductsImpl(TestDispatcherProvider(), service)

        // when
        val products = runBlocking {
            whenever(service.listProducts()).thenReturn(response)
            getProducts()
        }
        // then
        Assert.assertEquals(expected, products)
    }
}
