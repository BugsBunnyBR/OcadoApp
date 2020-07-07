package es.ocado.navigation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle

fun Activity.startDestination(destination: ActivityDestination) {
    val intent = destination.toIntent(this)
    startActivity(intent)
}

fun Activity.startDestinationForResult(destination: ActivityDestination, requestCode: Int) {
    val intent = destination.toIntent(this)
    startActivityForResult(intent, requestCode)
}

fun <T> SavedStateHandle.require(): T {
    return get<T>(EXTRA)!!
}

fun <T : Parcelable> Bundle.require(): T {
    return getParcelable(EXTRA)!!
}

private fun ActivityDestination.toIntent(activity: Activity): Intent {
    return Intent(activity, Class.forName(activityClass))
        .apply {
            putExtra(EXTRA, params)
        }
}

private const val EXTRA = "extra"
