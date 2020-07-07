package es.ocado.app

import android.app.Application
import es.ocado.navigation.ActivityDestination

open class BaseOcadoApp : Application() {
    open fun initialDestination(): ActivityDestination = object : ActivityDestination() {
        override val activityClass: String
            get() = throw Exception(
                "Your module application's should " +
                    "override initialDestination() method"
            )
    }
}
