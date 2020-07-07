package es.ocado.navigation.features.products.detail

import es.ocado.navigation.ActivityDestination

data class ProductDetailDestination(override val params: ProductDetailParams) :
    ActivityDestination() {
    override val activityClass =
        "es.ocado.features.product.detail.presentation.ProductDetailActivity"
}
