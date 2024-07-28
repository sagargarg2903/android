plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

kotlin {
    jvmToolchain {
        jvmToolchain(8)
    }
}

dependencies {
    implementation(project(":dagger"))
    implementation("com.squareup:kotlinpoet:1.14.2")
}