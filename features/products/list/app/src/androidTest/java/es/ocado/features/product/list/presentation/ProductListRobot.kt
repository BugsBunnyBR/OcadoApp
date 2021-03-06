package es.ocado.features.product.list.presentation

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import com.azimolabs.conditionwatcher.waitForCondition
import es.ocado.navigation.features.products.list.ProductListDestination
import es.ocado.navigation.toIntent

internal class ProductListRobot {
    fun open() {
        val intent = ProductListDestination
            .toIntent(InstrumentationRegistry.getInstrumentation().targetContext)
        ActivityScenario.launch<ProductListActivity>(intent)
    }

    fun openDetailsForItemTitle(title: String) {
        waitForCondition {
            onView(withText(title))
                .perform(click())
        }
    }

    companion object {
        fun productListRobot(block: ProductListRobot.() -> Unit) {
            ProductListRobot().apply {
                block()
            }
        }
    }
}
