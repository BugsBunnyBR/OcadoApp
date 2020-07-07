package es.ocado.features.product.detail.presentation

internal sealed class ViewState {
    data class Content(
        val price: String,
        val title: String,
        val size: String,
        val imageUrl: String,
        val description: String? = null,
        val allergyInformation: String? = null
    ) : ViewState()
}
