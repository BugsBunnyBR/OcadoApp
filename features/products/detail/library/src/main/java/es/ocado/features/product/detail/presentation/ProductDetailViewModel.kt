package es.ocado.features.product.detail.presentation

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.ocado.features.product.detail.domain.GetProductDetail
import es.ocado.features.product.detail.domain.model.ProductDetailEntity
import es.ocado.features.product.detail.domain.model.ProductDetailId
import es.ocado.features.product.detail.presentation.ErrorEvent.None
import es.ocado.features.product.detail.presentation.ErrorEvent.ShowError
import es.ocado.navigation.features.products.detail.ProductDetailParams
import es.ocado.navigation.require
import kotlinx.coroutines.launch

internal class ProductDetailViewModel @ViewModelInject constructor(
    @Assisted
    private val savedStateHandle: SavedStateHandle,
    private val getProductDetail: GetProductDetail
) : ViewModel() {

    private val params =
        savedStateHandle.require<ProductDetailParams>()
    private val initialContent = params.toContent()

    val viewState = MutableLiveData<ViewState>(initialContent)

    // NOTE: The error state will displayed at the same time as the content state,
    // so we need to have two LiveData to make the whole state replayable in a config change.
    val errorState = MutableLiveData<ErrorEvent>(None)

    fun onAction(action: ViewAction) {
        when (action) {
            is ViewAction.LoadDetails -> loadProductDetails()
        }
    }

    private fun loadProductDetails() {
        errorState.value = None
        viewModelScope.launch {
            runCatching { getProductDetail(ProductDetailId(params.id)) }
                .onSuccess { detail ->
                    viewState.value = initialContent.overrideWith(detail)
                }.onFailure {
                    errorState.value = ShowError
                }
        }
    }
}

private fun ProductDetailParams.toContent(): ViewState.Content {
    return ViewState.Content(
        price = price,
        title = title,
        size = size,
        imageUrl = imageUrl
    )
}

private fun ViewState.Content.overrideWith(detail: ProductDetailEntity): ViewState.Content {
    return copy(
        price = detail.price,
        title = detail.title,
        imageUrl = detail.imageUrl,
        description = detail.description,
        allergyInformation = detail.allergyInformation
    )
}
