package com.tezov.medium.gradle_plugin

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PropertyDelegate<V : Any?>(initialValue: (() -> V)? = null, private val onDidSet:((newValue:V)->Unit)? = null) : ReadWriteProperty<Any?, V> {
    @Suppress("ClassName")
    private companion object {
        object NOT_INITIALIZED
    }

    private var value: Any? = if (initialValue != null) {
        initialValue.invoke()
    } else {
        NOT_INITIALIZED
    }

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Any?, property: KProperty<*>) =
        (value as? NOT_INITIALIZED)?.let {
            throw IllegalAccessError("Value is not initialized")
        } ?: value as V

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: V) {
        this.value = value
        onDidSet?.invoke(value)
    }


}