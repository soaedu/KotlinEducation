package data.operations.type_cast.example2

import java.io.File

/*
Java casting:
    public void printStringLength(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj
            System.out.print(str.length())
        }
    }
*/

fun main() {
    val str1 = "Abcdefg"
    printStringLength(str1)

    val str2_1 = "A"
    println("2_1. \"$str2_1\" is empty: ${isEmptyString(str2_1)}")

    val str2_2 = ""
    println("2_2. \"$str2_2\" is empty: ${isEmptyString(str2_2)}")

    val str3_1 = 123
    println("3_1. \"$str3_1\" is not a string or it is empty: ${isNotStringOrEmpty(str3_1)}")

    val str3_2 = File("filePath")
    println("3_2. \"$str3_2\" is not a string or it is empty: ${isNotStringOrEmpty(str3_2)}")
}

fun printStringLength(any: Any) {
    if (any is String) {
        println("\n1. \"$any\" length is: ${any.length}")
    }
}

fun isEmptyString(any: Any): Boolean {
    return any is String && any.length == 0
}

fun isNotStringOrEmpty(any: Any): Boolean {
    return any !is String || any.length == 0
}