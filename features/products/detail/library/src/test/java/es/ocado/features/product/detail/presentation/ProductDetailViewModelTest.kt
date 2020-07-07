package es.ocado.features.product.detail.presentation

import androidx.lifecycle.SavedStateHandle
import com.jraska.livedata.test
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import es.ocado.basetest.CoroutinesTestExtension
import es.ocado.basetest.InstantExecutorExtension
import es.ocado.features.product.detail.domain.GetProductDetail
import es.ocado.features.product.detail.domain.model.ProductDetailEntity
import es.ocado.features.product.detail.domain.model.ProductDetailId
import es.ocado.navigation.features.products.detail.ProductDetailParams
import es.ocado.navigation.require
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
internal class ProductDetailViewModelTest {
    val savedStateHandle: SavedStateHandle = mock()
    val getProductDetail: GetProductDetail = mock()
    val navParams = ProductDetailParams(
        id = "id",
        title = "title",
        size = "size",
        price = "price",
        imageUrl = "imageUrl"
    )
    val expectedInitial = ViewState.Content(
        price = "price",
        title = "title",
        size = "size",
        imageUrl = "imageUrl"
    )

    @Test
    fun `should publish initial value from parameters`() {
        // Given
        whenever(savedStateHandle.require<ProductDetailParams>())
            .thenReturn(navParams)

        // when
        val viewModel = ProductDetailViewModel(savedStateHandle, getProductDetail)
        val testObserver = viewModel.viewState.test()
        val errorTestObserver = viewModel.errorState.test()

        // then
        testObserver.assertValue(expectedInitial)
        errorTestObserver.assertValueHistory(ErrorEvent.None)
    }

    @Test
    fun `should load product detail`() = runBlockingTest {
        // Given
        val productDetail = ProductDetailEntity(
            id = ProductDetailId("id"),
            price = "price detail",
            title = "title detail",
            imageUrl = "imageUrl detail",
            allergyInformation = "allergyInformation",
            description = "description"
        )

        val expectedDetail = ViewState.Content(
            price = "price detail",
            title = "title detail",
            size = "size",
            imageUrl = "imageUrl detail",
            allergyInformation = "allergyInformation",
            description = "description"
        )
        whenever(savedStateHandle.require<ProductDetailParams>())
            .thenReturn(navParams)

        whenever(
            getProductDetail(
                ProductDetailId(
                    "id"
                )
            )
        ).thenReturn(productDetail)

        val viewModel = ProductDetailViewModel(savedStateHandle, getProductDetail)
        val testObserver = viewModel.viewState.test()
        val errorTestObserver = viewModel.errorState.test()

        // when
        viewModel.onAction(ViewAction.LoadDetails)

        // then
        testObserver.assertValueHistory(expectedInitial, expectedDetail)
        errorTestObserver.assertValueHistory(ErrorEvent.None, ErrorEvent.None)
    }

    @Test
    fun `should fail to load product detail`() = runBlockingTest {
        // Given
        whenever(savedStateHandle.require<ProductDetailParams>())
            .thenReturn(navParams)
        val getProductDetail = object : GetProductDetail {
            override suspend fun invoke(id: ProductDetailId): ProductDetailEntity {
                throw IOException()
            }
        }

        val viewModel = ProductDetailViewModel(savedStateHandle, getProductDetail)
        val viewTestObserver = viewModel.viewState.test()
        val errorTestObserver = viewModel.errorState.test()

        // when
        viewModel.onAction(ViewAction.LoadDetails)

        // then
        viewTestObserver.assertValueHistory(expectedInitial)
        errorTestObserver.assertValueHistory(ErrorEvent.None, ErrorEvent.None, ErrorEvent.ShowError)
    }
}
