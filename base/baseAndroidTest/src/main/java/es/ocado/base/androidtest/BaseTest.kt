package es.ocado.base.androidtest

import dagger.hilt.android.testing.HiltAndroidRule
import dispatch.android.espresso.IdlingDispatcherProvider
import dispatch.android.espresso.IdlingDispatcherProviderRule

import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule

open class BaseTest {

    companion object {
        const val MOCK_WEB_SERVER_PORT = 13445
        val testDispatcherProvider = IdlingDispatcherProvider()
    }

    @get:Rule
    val coroutinesRule = IdlingDispatcherProviderRule {
        testDispatcherProvider
    }

    @get:Rule
    val hiltRule = HiltAndroidRule(this)
    protected val server = MockWebServer()

    @Before
    fun setup() {
        server.start(MOCK_WEB_SERVER_PORT)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}
