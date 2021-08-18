package data.type.classes.operation.delegation.example2

import kotlin.reflect.KProperty

// #1
class Config(val data: MutableMap<String, Any?>) {
    var Url: String
        get() = data["Url"] as String
        set(value) {
            data["Url"] = value
        }
}

// #2
class BetterConfig(val data: MutableMap<String, Any?>) {
    var Url: String by data
}

/*class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        // get the actual value you want
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        // set the actual value you want
    }
}*/

/*
// getter
public inline operator fun <V, V1: V> MutableMap<in String, out V>.getValue(
        thisRef: Any?, property: KProperty<*>): V1  =
            getOrImplicitDefault(property.name) as V1

// setter
public inline operator fun <V> MutableMap<in String, in V>.setValue(
        thisRef: Any?, property: KProperty<*>, value: V) {
    put(property.name, value)
}
*/