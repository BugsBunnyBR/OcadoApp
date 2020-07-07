package es.ocado.features.product.list.presentation

import es.ocado.features.product.list.domain.model.ProductEntity

internal sealed class ViewAction {
    data class SelectProduct(val product: ProductEntity) : ViewAction()
    object LoadContent : ViewAction()
}
