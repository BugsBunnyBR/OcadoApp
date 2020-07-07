package es.ocado.app

import dagger.hilt.android.HiltAndroidApp
import es.ocado.navigation.ActivityDestination
import es.ocado.navigation.features.products.list.ProductListDestination

@HiltAndroidApp
internal class OcadoApp : BaseOcadoApp(){
     override fun initialDestination(): ActivityDestination {
        return ProductListDestination
    }
}
