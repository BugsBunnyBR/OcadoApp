/* ktlint-disable max-line-length */
package es.ocado.app

import dagger.hilt.android.HiltAndroidApp
import es.ocado.navigation.ActivityDestination
import es.ocado.navigation.features.products.detail.ProductDetailDestination
import es.ocado.navigation.features.products.detail.ProductDetailParams

@HiltAndroidApp
internal class OcadoApp : BaseOcadoApp() {
    @Suppress("MaxLineLength")
    override fun initialDestination(): ActivityDestination {
        return ProductDetailDestination(
            ProductDetailParams(
                id = "309396011",
                price = "1.45",
                title = "Ocado Organic Fairtrade Bananas",
                imageUrl = "https://mobile.ocado.com/webservices/catalogue/items/item/309396011/images/image/0/360x360.jpg",
                size = "6 per pack"
            )
        )
    }
}
