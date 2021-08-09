package data.operations.type_cast.example2

fun main() {
    val str = "Abcd"
    val nullStr = null
    println("1. \"$str\" length is: ${length(str)}")
    println("2. null string length is: ${length(nullStr)}")
}

// #1
/*
fun length(any: Any): Int {
    val string = any as String
    return string.length
}*/

// #2
// Throws "TypeCastException" if the value is null
/*
fun length(any: Any?): Int {
    val string: String? = any as String
    return string!!.length
}*/

// #3
// Returns null as the length calculation result when the value is null
fun length(any: Any?): Int? {
    val string: String? = any as? String
    return string?.length
}