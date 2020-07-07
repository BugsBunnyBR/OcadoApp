package es.ocado.navigation.features.products.list

import es.ocado.navigation.ActivityDestination

object ProductListDestination :
    ActivityDestination() {
    override val activityClass =
        "es.ocado.features.product.list.presentation.ProductListActivity"
}
