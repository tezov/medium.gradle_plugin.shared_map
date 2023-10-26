package com.tezov.medium.gradle_plugin

import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import javax.inject.Inject

open class ExtensionModule @Inject constructor(
    factory: ObjectFactory,
    private val project: Project
) {

    var map by PropertyDelegate(initialValue = { mapOf<String, String>() })
        internal set
}