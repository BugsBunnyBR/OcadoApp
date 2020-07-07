/* ktlint-disable max-line-length */
package es.ocado.features.product.list.data

import es.ocado.features.product.list.domain.model.ProductEntity
import es.ocado.features.product.list.domain.model.ProductId

internal object ListContent {
    object Data {
        val productsBody: String =
            """
                {
                  "clusters": [
                    {
                      "tag": "Bananas",
                      "items": [
                        {
                          "id": 309396011,
                          "price": "1.45",
                          "title": "Ocado Organic Fairtrade Bananas",
                          "size": "6 per pack",
                          "imageUrl": "https://mobile.ocado.com/webservices/catalogue/items/item/309396011/images/image/0/240x240.jpg"
                        },
                        {
                          "id": 227255011,
                          "price": "4.45",
                          "title": "Ocado Fairtrade Ripen at Home Bananas",
                          "size": "5 per pack",
                          "imageUrl": "https://mobile.ocado.com/webservices/catalogue/items/item/227255011/images/image/0/240x240.jpg"
                        }
                      ]
                    },
                    {
                      "tag": "Sugar & Home Baking",
                      "items": [
                        {
                          "id": 386138011,
                          "price": "0.90",
                          "title": "Ocado Sunflower Seeds",
                          "size": "100g",
                          "imageUrl": "https://mobile.ocado.com/webservices/catalogue/items/item/386138011/images/image/0/240x240.jpg"
                        },
                        {
                          "id": 407680011,
                          "price": "0.60",
                          "title": "Ocado Self Raising Flour",
                          "size": "1.5kg",
                          "imageUrl": "https://mobile.ocado.com/webservices/catalogue/items/item/407680011/images/image/0/240x240.jpg"
                        },
                        {
                          "id": 386132011,
                          "price": "2.00",
                          "title": "Ocado Prunes",
                          "size": "250g",
                          "imageUrl": "https://mobile.ocado.com/webservices/catalogue/items/item/386132011/images/image/0/240x240.jpg"
                        }
                      ]
                    },
                    {
                      "tag": "Cucumber",
                      "items": [
                        {
                          "id": 240875011,
                          "price": "0.64",
                          "title": "Ocado Cucumber",
                          "size": "1 per pack",
                          "imageUrl": "https://mobile.ocado.com/webservices/catalogue/items/item/240875011/images/image/0/240x240.jpg"
                        }
                      ]
                    },
                    {
                      "tag": "Naan Bread",
                      "items": [
                        {
                          "id": 91056011,
                          "price": "1.15",
                          "title": "Ocado Mini Garlic & Coriander Naan",
                          "size": "6 per pack",
                          "imageUrl": "https://mobile.ocado.com/webservices/catalogue/items/item/91056011/images/image/0/240x240.jpg"
                        },
                        {
                          "id": 91061011,
                          "price": "0.95",
                          "title": "Ocado Garlic & Coriander Naan",
                          "size": "2 per pack",
                          "imageUrl": "https://mobile.ocado.com/webservices/catalogue/items/item/91061011/images/image/0/240x240.jpg"
                        }
                      ]
                    },
                    {
                      "tag": "Leeks & Garlic",
                      "items": [
                        {
                          "id": 91500011,
                          "price": "1.35",
                          "title": "Ocado Baby Leeks",
                          "size": "110g",
                          "imageUrl": "https://mobile.ocado.com/webservices/catalogue/items/item/91500011/images/image/0/240x240.jpg"
                        },
                        {
                          "id": 65453011,
                          "price": "0.85",
                          "title": "Ocado Red Onions",
                          "size": "3 per pack",
                          "imageUrl": "https://mobile.ocado.com/webservices/catalogue/items/item/65453011/images/image/0/240x240.jpg"
                        },
                        {
                          "id": 65448011,
                          "price": "0.85",
                          "title": "Ocado Brown Onions",
                          "size": "3 per pack",
                          "imageUrl": "https://mobile.ocado.com/webservices/catalogue/items/item/65448011/images/image/0/240x240.jpg"
                        },
                        {
                          "id": 299133011,
                          "price": "1.20",
                          "title": "Ocado Organic Garlic",
                          "size": "4 per pack",
                          "imageUrl": "https://mobile.ocado.com/webservices/catalogue/items/item/299133011/images/image/0/240x240.jpg"
                        },
                        {
                          "id": 81851011,
                          "price": "1.00",
                          "title": "Ocado Shallots",
                          "size": "400g",
                          "imageUrl": "https://mobile.ocado.com/webservices/catalogue/items/item/81851011/images/image/0/240x240.jpg"
                        }
                      ]
                    }
                  ]
                }
            """.trimIndent()
    }

    val product = ProductEntity(
        id = ProductId("309396011"),
        price = "1.45",
        title = "Ocado Organic Fairtrade Bananas",
        imageUrl = "https://mobile.ocado.com/webservices/catalogue/items/item/309396011/images/image/0/360x360.jpg",
        size = "6 per pack"
    )
}
