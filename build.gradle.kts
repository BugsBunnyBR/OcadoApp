buildscript {
    val kotlin_version by extra("1.4.10")
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.29.1-alpha")
        classpath("de.mannodermaus.gradle.plugins:android-junit5:1.6.2.0")
    }
}
plugins {
    id("io.gitlab.arturbosch.detekt") version "1.10.0"
}
allprojects {
    apply(from = "$rootDir/build-system/ktlint.gradle")
    apply(from = "$rootDir/build-system/detekt.gradle")

    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }
}
