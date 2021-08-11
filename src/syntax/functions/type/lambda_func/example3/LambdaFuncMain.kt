package syntax.functions.type.lambda_func.example3

fun main() {

    // #1
    // return is not allowed in this lambda,
    // because it looks like you want to return from main() function.
    /*bar(Math.PI) { angle ->
        if (angle == 0.0) return Double.NaN
        return Math.sin(angle) + Math.cos(angle)
    }*/

    // #2
    // we can use "return" with label
    val result = bar(Math.PI) { angle ->
        if (angle == 0.0) return@bar Double.NaN
        return@bar Math.sin(angle) + Math.cos(angle)
    }
    println("1. sin: ${Math.sin(Math.PI)} \ncos: ${Math.cos(Math.PI)} \nsin+cos: $result")

    val fruits = listOf("", "", "Banana", "Apple", "", "Pear", "Peach",  "", "Plum", "Lemon", "")
    youShallPrintlnAfterEmptyStr(fruits)
}

fun bar(angle: Double, f: (Double) -> Double): Double {
    return f(angle)
}

fun youShallPrintlnAfterEmptyStr(list: List<String>) {
    println("2. show fruits")

    list.forEach { str ->
        if (str.isEmpty()) return@forEach
        println(str)
    }
}

