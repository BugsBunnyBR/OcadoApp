package es.ocado.features.product.list.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.ocado.features.product.list.domain.GetProducts
import es.ocado.features.product.list.domain.model.ProductEntity
import es.ocado.features.product.list.presentation.NavigationEvent.OpenProductDetail
import es.ocado.features.product.list.presentation.ViewAction.LoadContent
import es.ocado.features.product.list.presentation.ViewAction.SelectProduct
import es.ocado.features.product.list.presentation.ViewState.ContentLoaded
import es.ocado.navigation.features.products.detail.ProductDetailParams
import es.ocado.base.library.utils.SingleLiveEvent
import es.ocado.base.library.utils.exhaustive
import kotlinx.coroutines.launch

internal class ProductListViewModel @ViewModelInject constructor(
    private val getProducts: GetProducts
) : ViewModel() {

    val viewState = MutableLiveData<ViewState>()

    // NOTE: Non replayable event
    val navigationEvent = SingleLiveEvent<NavigationEvent>()

    fun onAction(action: ViewAction) {
        when (action) {
            is LoadContent -> loadProducts()
            is SelectProduct -> showProductDetail(action.product)
        }.exhaustive
    }

    private fun showProductDetail(product: ProductEntity) {
        navigationEvent.value = OpenProductDetail(product.toProductDetails())
    }

    private fun loadProducts() {
        viewModelScope.launch {
            runCatching { getProducts() }
                .onSuccess { products ->
                    viewState.value = ContentLoaded(products)
                }.onFailure {
                    viewState.value = ViewState.Error
                }
        }
    }
}

private fun ProductEntity.toProductDetails(): ProductDetailParams {
    return ProductDetailParams(
        id = id.id,
        imageUrl = imageUrl,
        price = price,
        size = size,
        title = title
    )
}
