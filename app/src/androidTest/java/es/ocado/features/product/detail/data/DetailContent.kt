/* ktlint-disable max-line-length */
package es.ocado.features.product.detail.data

import es.ocado.features.product.detail.domain.model.ProductDetailEntity
import es.ocado.features.product.detail.domain.model.ProductDetailId
import es.ocado.features.product.list.domain.model.ProductEntity
import es.ocado.features.product.list.domain.model.ProductId
import es.ocado.navigation.features.products.detail.ProductDetailParams

internal object DetailContent {
    object Data {
        val detailBody: String =
            /* ktlint-disable max_line_length */
            """ 
                {
                  "id": 309396011,
                  "price": "1.45",
                  "title": "Ocado Organic Fairtrade Bananas",
                  "imageUrl": "https://mobile.ocado.com/webservices/catalogue/items/item/309396011/images/image/0/360x360.jpg",
                  "description": "Organic. Suitable for vegetarians",
                  "allergyInformation": "May contain traces of Sesame Seeds"
                }
            """.trimIndent()
    }

    val params = ProductDetailParams(
        id = "309396011",
        price = "1.45",
        title = "Ocado Organic Fairtrade Bananas",
        imageUrl = "https://mobile.ocado.com/webservices/catalogue/items/item/309396011/images/image/0/360x360.jpg",
        size = "6 per pack"
    )
    val product = ProductEntity(
        id = ProductId("309396011"),
        price = "1.45",
        title = "Ocado Organic Fairtrade Bananas",
        imageUrl = "https://mobile.ocado.com/webservices/catalogue/items/item/309396011/images/image/0/360x360.jpg",
        size = "6 per pack"
    )

    val detail = ProductDetailEntity(
        id = ProductDetailId("309396011"),
        price = "1.45",
        title = "Ocado Organic Fairtrade Bananas",
        imageUrl = "https://mobile.ocado.com/webservices/catalogue/items/item/309396011/images/image/0/360x360.jpg",
        description = "Organic. Suitable for vegetarians",
        allergyInformation = "May contain traces of Sesame Seeds"
    )
}
