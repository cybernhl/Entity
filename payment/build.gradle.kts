import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
    `maven-publish`
}

group = "com.github.cybernhl.Entity"
version = "1.0-SNAPSHOT"

configurations.all {
    resolutionStrategy.cacheChangingModulesFor(0, "seconds")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    val xcfName = "paymentSpayKit"
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = xcfName
            isStatic = true
        }
    }

    jvm() {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilations.all {
            compilerOptions.configure {
                jvmTarget.set(JvmTarget.JVM_11)
            }
        }
    }

    js {
        browser()
        nodejs()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        nodejs()
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation (libs.kotlinx.serialization.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.bignum)
            implementation("com.github.cybernhl.Entity:general:0.0.6")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.biqbila.entity.payment.bilapay"
    compileSdk = 36
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = 21
    }
}

tasks.matching { it.name.startsWith("publish") }.configureEach {
    doLast {
        val userHome = System.getProperty("user.home")
        val mavenLocalDir = File(userHome, ".m2/repository/com/github/cybernhl/Entity")
        if (mavenLocalDir.exists()) {
            mavenLocalDir.walkTopDown().filter { it.isFile && it.name.endsWith("-metadata.jar") }.forEach { file ->
                val targetFile = File(file.parentFile, file.name.replace("-metadata.jar", ".jar"))
                if (!targetFile.exists()) {
                    file.copyTo(targetFile, overwrite = true)
                }
            }
        }
    }
}
