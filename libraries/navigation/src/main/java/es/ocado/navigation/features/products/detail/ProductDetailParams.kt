package es.ocado.navigation.features.products.detail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductDetailParams(
    val id: String,
    val price: String,
    val title: String,
    val size: String,
    val imageUrl: String
) : Parcelable
