package com.tezov.medium.gradle_plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class PluginEntry : Plugin<Project> {

    companion object {
        internal const val PLUGIN_ID = "com.tezov.medium.gradle_plugin.shared_map"
        internal const val EXTENSION_NAME_ROOT = "myPluginRoot"
        internal const val EXTENSION_NAME_MODULE = "myPluginModule"
    }

    override fun apply(project: Project) {
        project.takeIf { it === project.rootProject }?.let {
            project.extensions.create(EXTENSION_NAME_ROOT, ExtensionRoot::class.java)

        } ?: run {
            project.extensions.create(EXTENSION_NAME_MODULE, ExtensionModule::class.java)
        }
    }

}
