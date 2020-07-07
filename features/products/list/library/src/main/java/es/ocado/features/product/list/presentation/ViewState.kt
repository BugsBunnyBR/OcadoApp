package es.ocado.features.product.list.presentation

import es.ocado.features.product.list.domain.model.ProductClusterEntity

internal sealed class ViewState {
    data class ContentLoaded(val clusters: List<ProductClusterEntity>) : ViewState()
    object Error : ViewState()
}
