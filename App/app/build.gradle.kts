plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

myPluginModule {
    /*
        Used of custom plugin. We didn't add the plugin id here because
        it was added by the plugin itself to each modules.

        Result in build output = {key1=value1, key2=value2, key3=value3, key4=value4}
    */
    println(map)
}

android {
    namespace = "com.tezov.medium.gradle_plugin.shared_map.app"
    compileSdk = 34

    defaultConfig {
        applicationId = namespace
        minSdk = 24
        targetSdk = 34
        versionCode = 10000
        versionName = "1.0.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

}