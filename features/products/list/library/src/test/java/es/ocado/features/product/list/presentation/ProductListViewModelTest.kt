package es.ocado.features.product.list.presentation

import com.jraska.livedata.test
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import es.ocado.basetest.CoroutinesTestExtension
import es.ocado.basetest.InstantExecutorExtension
import es.ocado.features.product.list.domain.model.ProductId
import es.ocado.features.product.list.domain.GetProducts
import es.ocado.features.product.list.domain.model.ProductClusterEntity
import es.ocado.features.product.list.domain.model.ProductEntity
import es.ocado.navigation.features.products.detail.ProductDetailParams
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.io.IOException

@ExtendWith(
    value = [
        CoroutinesTestExtension::class,
        InstantExecutorExtension::class
    ]
)
class ProductListViewModelTest {

    @Test
    fun `should load content when action is triggered`() = runBlockingTest {
        // Given
        val getProducts = mock<GetProducts>()
        whenever(getProducts.invoke()).thenReturn(emptyList())
        val viewModel = ProductListViewModel(getProducts)
        val testObserver = viewModel.viewState.test()

        // when
        viewModel.onAction(ViewAction.LoadContent)

        // then
        testObserver.assertValueHistory(ViewState.ContentLoaded(emptyList()))
    }

    @Test
    fun `should show error when failed action load content is triggered`() = runBlockingTest {
        // Given
        val getProducts = object : GetProducts {
            override suspend fun invoke(): List<ProductClusterEntity> {
                throw IOException()
            }
        }
        val viewModel = ProductListViewModel(getProducts)
        val testObserver = viewModel.viewState.test()

        // when
        viewModel.onAction(ViewAction.LoadContent)

        // then
        testObserver.assertValueHistory(ViewState.Error)
    }

    @Test
    fun `should select product when action is triggered`() = runBlockingTest {
        // Given
        val getProducts = mock<GetProducts>()
        whenever(getProducts.invoke()).thenReturn(emptyList())
        val viewModel = ProductListViewModel(getProducts)
        val testObserver = viewModel.navigationEvent.test()
        val product = ProductEntity(
            id = ProductId("id"),
            title = "title",
            size = "size",
            price = "price",
            imageUrl = "imageUrl"
        )
        val navParams = ProductDetailParams(
            id = "id",
            title = "title",
            size = "size",
            price = "price",
            imageUrl = "imageUrl"
        )

        // when
        viewModel.onAction(ViewAction.SelectProduct(product))

        // then
        testObserver.assertValueHistory(NavigationEvent.OpenProductDetail(navParams))
    }
}
