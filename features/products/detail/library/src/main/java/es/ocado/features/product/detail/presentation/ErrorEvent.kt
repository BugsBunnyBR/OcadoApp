package es.ocado.features.product.detail.presentation

internal sealed class ErrorEvent {
    object ShowError : ErrorEvent()

    // In a config change we want to show the snackbar again,
    // but when the user request to try again we should remove the error state
    object None : ErrorEvent()
}
