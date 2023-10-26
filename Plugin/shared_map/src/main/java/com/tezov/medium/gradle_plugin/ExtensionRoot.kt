package com.tezov.medium.gradle_plugin

import com.tezov.medium.gradle_plugin.PluginEntry.Companion.EXTENSION_NAME_MODULE
import com.tezov.medium.gradle_plugin.PluginEntry.Companion.PLUGIN_ID
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import javax.inject.Inject

open class ExtensionRoot @Inject constructor(
    factory: ObjectFactory,
    private val project: Project
) {

    var map by PropertyDelegate (
        initialValue = { mapOf<String, String>() },
        onDidSet = { newValue ->
            project.allprojects.filter { it !== project }.forEach { module ->
                module.plugins.apply(PLUGIN_ID)
                kotlin.runCatching {
                    module.extensions.findByName(EXTENSION_NAME_MODULE) as? ExtensionModule
                }.getOrNull()?.let {
                    it.map = newValue
                } ?: kotlin.run {
                    println("not found")
                }
            }
        }
    )

}