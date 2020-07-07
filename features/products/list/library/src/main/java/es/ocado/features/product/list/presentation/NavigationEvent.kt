package es.ocado.features.product.list.presentation

import es.ocado.navigation.features.products.detail.ProductDetailParams

internal sealed class NavigationEvent {
    data class OpenProductDetail(val params: ProductDetailParams) : NavigationEvent()
}
