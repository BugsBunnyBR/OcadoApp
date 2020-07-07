object Versions {

}

object Dependencies {

    const val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7"

    const val android_core = "androidx.core:core-ktx:1.3.0"
    const val android_appcompat = "androidx.appcompat:appcompat:1.1.0"
    const val android_activity = "androidx.activity:activity-ktx:1.1.0"
    const val android_fragment = "androidx.fragment:fragment-ktx:1.2.5"
    const val android_recyclerview = "androidx.recyclerview:recyclerview:1.2.0-alpha04"
    const val android_lifecycle = "android.arch.lifecycle:extensions:1.1.1"
    const val android_lifecycle_saved_state = "androidx.lifecycle:lifecycle-viewmodel-savedstate:2.2.0"
    const val android_constraint_layout = "androidx.constraintlayout:constraintlayout:1.1.3"

    const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    const val retrofit_moshi = "com.squareup.retrofit2:converter-moshi:2.9.0"

    const val okhttp_logging_interceptor = "com.squareup.okhttp3:logging-interceptor:4.7.2"

    const val hilt_android = "com.google.dagger:hilt-android:2.28.1-alpha"
    const val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:2.28.1-alpha"
    const val hilt_android_testing = "com.google.dagger:hilt-android-testing:2.28-alpha"

    const val hilt_lifecyle_viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"
    const val hilt_compiler = "androidx.hilt:hilt-compiler:1.0.0-alpha01"

    const val android_material = "com.google.android.material:material:1.3.0-alpha01"
    const val dispatchers_android_viewmodel =
        "com.rickbusarow.dispatch:dispatch-android-viewmodel:1.0.0-beta04"
    const val dispatchers_android_espresso =
        "com.rickbusarow.dispatch:dispatch-android-espresso:1.0.0-beta04"

    const val coil = "io.coil-kt:coil:0.11.0"

    const val android_ext_junit = "androidx.test.ext:junit:1.1.1"
    const val espresso_core = "androidx.test.espresso:espresso-core:3.2.0"
    const val android_test_runner = "androidx.test:runner:1.2.0"
    const val android_test_rules = "androidx.test:rules:1.2.0"
    const val okhttp_mockwebserver = "com.squareup.okhttp3:mockwebserver:4.7.2"
}

object Modules {
    const val baseApp = ":base:baseApp"
    const val baseAndroidTest = ":base:baseAndroidTest"
    const val baseMain = ":base:baseLibrary"
    const val baseTest = ":base:baseTest"

    const val navigation = ":libraries:navigation"
    const val components = ":libraries:components"

    const val productsList = ":features:products:list:library"
    const val productsDetail = ":features:products:detail:library"
}
