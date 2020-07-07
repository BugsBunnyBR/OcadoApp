package es.ocado.features.product.detail.presentation

import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import com.azimolabs.conditionwatcher.waitForCondition
import es.ocado.features.product.detail.R
import es.ocado.features.product.detail.domain.model.ProductDetailEntity
import es.ocado.navigation.features.products.detail.ProductDetailDestination
import es.ocado.navigation.features.products.detail.ProductDetailParams
import es.ocado.navigation.toIntent
import org.hamcrest.Matchers

internal class ProductDetailRobot {
    fun open(params: ProductDetailParams) {

        val intent = ProductDetailDestination(params)
            .toIntent(InstrumentationRegistry.getInstrumentation().targetContext)
        ActivityScenario.launch<ProductDetailActivity>(intent)
    }

    fun isOnDetailsScreen(product: ProductDetailParams, detail: ProductDetailEntity) {
        isTextDisplayed(detail.title)
        isDescriptionShown(detail.description)
        isAllergyInformationShown(detail.allergyInformation)
        isTextDisplayed(detail.price)
        isSizeShown(product.size)
    }

    fun retry() {
        waitForCondition {
            Espresso.onView(ViewMatchers.withText(R.string.product_detail_retry_action))
                .perform(ViewActions.click())
        }
    }

    private fun isSizeShown(size: String) {
        isTitleDescriptionViewShown(
            R.id.productSize,
            R.string.product_detail_size,
            size
        )
    }

    private fun isDescriptionShown(description: String) {
        isTitleDescriptionViewShown(
            R.id.productDescription,
            R.string.product_detail_activity_about,
            description
        )
    }

    private fun isAllergyInformationShown(allergyInformation: String) {
        isTitleDescriptionViewShown(
            R.id.productAllergyInformation,
            R.string.product_detail_allergy_information,
            allergyInformation
        )
    }

    private fun isTitleDescriptionViewShown(
        @IdRes viewId: Int,
        @StringRes title: Int,
        description: String
    ) {
        waitForCondition {
            Espresso.onView(
                Matchers.allOf(
                    ViewMatchers.withId(viewId),
                    ViewMatchers.hasDescendant(ViewMatchers.withText(title)),
                    ViewMatchers.hasDescendant(ViewMatchers.withText(description))
                )
            ).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }
    }

    private fun isTextDisplayed(text: String) {
        waitForCondition {
            Espresso.onView(ViewMatchers.withText(text))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }
    }

    companion object {
        fun productDetailRobot(block: ProductDetailRobot.() -> Unit) {
            ProductDetailRobot().apply {
                block()
            }
        }
    }
}
