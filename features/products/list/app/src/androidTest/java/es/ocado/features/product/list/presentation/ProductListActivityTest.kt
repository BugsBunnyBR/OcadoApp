package es.ocado.features.product.list.presentation

import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import es.ocado.app.di.ApplicationModule
import es.ocado.base.androidtest.BaseTest
import es.ocado.features.product.list.data.ListContent
import es.ocado.features.product.list.presentation.ProductListRobot.Companion.productListRobot
import okhttp3.mockwebserver.MockResponse
import org.junit.Test

@UninstallModules(value = [ApplicationModule::class])
@HiltAndroidTest
class ProductListActivityTest : BaseTest() {

    @Test
    fun shouldOpenProductDetails() {
        server.enqueue(
            MockResponse().apply {
                setBody(ListContent.Data.productsListBody)
            }
        )
        server.enqueue(
            MockResponse().apply {
                setResponseCode(404)
            }
        )
        productListRobot {
            open()
            openDetailsForItemTitle(ListContent.product.title)
        }
    }
}
