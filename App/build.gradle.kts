plugins {
    id("com.tezov.medium.gradle_plugin.shared_map")
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
}

myPluginRoot {
    map = mapOf(
        "key1" to "value1",
        "key2" to "value2",
        "key3" to "value3",
        "key4" to "value4",
    )
}