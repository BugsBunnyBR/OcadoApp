package es.ocado.navigation

import android.os.Parcelable

interface Destination

abstract class ActivityDestination : Destination {
    abstract val activityClass: String
    open val params: Parcelable? = null
}
