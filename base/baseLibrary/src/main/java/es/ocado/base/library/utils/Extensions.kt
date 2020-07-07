package es.ocado.base.library.utils

import android.widget.ImageView
import androidx.core.view.doOnPreDraw
import coil.api.load

val <T> T.exhaustive: T
    get() = this

/**
 * Loads the biggest width possible from a given url.
 * */
fun ImageView.loadImage(
    rawImageUrl: String,
    imagePlaceHolder: Int = android.R.drawable.picture_frame
) {
    doOnPreDraw {
        val fileType = rawImageUrl
            .split(".")
            .last()
        val imageUrl = rawImageUrl
            .split("/")
            .dropLast(1)
            .joinToString("/") + "/" + width + "x" + width + "." + fileType

        load(imageUrl) {
            crossfade(true)
            placeholder(imagePlaceHolder)
        }
    }
}
