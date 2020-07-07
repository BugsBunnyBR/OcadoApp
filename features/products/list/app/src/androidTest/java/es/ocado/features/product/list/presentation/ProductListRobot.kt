package es.ocado.features.product.list.presentation

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.azimolabs.conditionwatcher.waitForCondition

internal class ProductListRobot {
    fun open() {
        ActivityScenario.launch(ProductListActivity::class.java)
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
