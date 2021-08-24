package generics.example2

import data.type.classes.type.data_class.example3.SignUpMsg

fun main(args: Array<String>) {
    val l = listOf(1, "", 5.0).removeAllInstancesOf<String>()
    println(l)
}

/*
// #1
inline fun <R> List<Any>.removeAllInstancesOf(): List<Any> {
    val res = listOf<Any>()
    for (e in this) {
        if (e !is R) res += e	// Nope does not work
    }
    return res
}
*/

// #2
inline fun <reified R> List<Any>.removeAllInstancesOf(): List<Any> {
    val res = mutableListOf<Any>()
    for (e in this)
        if (e !is R) res += e
    return res
}

/*
fun main(args: Array<String>) {
    dumpAllMembers<SignUpMsg>()
}

inline fun <reified T> dumpAllMembers() =
        T::class
                .members
                .forEach(::println)
*/