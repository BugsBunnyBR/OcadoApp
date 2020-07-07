package es.ocado.features.product.detail.presentation

import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import es.ocado.app.di.ApplicationModule
import es.ocado.base.androidtest.BaseTest
import es.ocado.features.product.detail.data.DetailContent
import es.ocado.features.product.detail.presentation.ProductDetailRobot.Companion.productDetailRobot
import okhttp3.mockwebserver.MockResponse
import org.junit.Test

@UninstallModules(value = [ApplicationModule::class])
@HiltAndroidTest
class ProductDetailActivityTest : BaseTest() {

    @Test
    fun shouldOpenProductDetailsSuccessfully() {
        server.enqueue(
            MockResponse().apply {
                setBody(DetailContent.Data.productDetailBody)
            }
        )
        productDetailRobot {
            open(DetailContent.params)
            isOnDetailsScreen(
                DetailContent.params,
                DetailContent.detail
            )
        }
    }

    @Test
    fun shouldOpenDetailsAndShowRetryThenRetrySuccessfully() {
        server.enqueue(
            MockResponse().apply {
                setResponseCode(404)
            }
        )
        server.enqueue(
            MockResponse().apply {
                setBody(DetailContent.Data.productDetailBody)
            }
        )
        productDetailRobot {
            open(DetailContent.params)
            retry()
            isOnDetailsScreen(
                DetailContent.params,
                DetailContent.detail
            )
        }
    }
}
