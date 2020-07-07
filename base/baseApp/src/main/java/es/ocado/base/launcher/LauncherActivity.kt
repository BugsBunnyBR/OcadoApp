package es.ocado.base.launcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.ocado.app.BaseOcadoApp
import es.ocado.navigation.startDestination

 class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startDestination((application as BaseOcadoApp).initialDestination())
        finish()
    }
}
