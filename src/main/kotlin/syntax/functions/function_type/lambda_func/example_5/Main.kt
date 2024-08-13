package syntax.functions.function_type.lambda_func.example_5

fun main() {
    val fruits = listOf("", "", "Banana", "Apple", "", "Pear", "Peach",  "", "Plum", "Lemon", "")
    filterFruits(fruits)
}

fun filterFruits(fruits: List<String>) {
    val result = mutableListOf<String>()

    // #1
    /*fruits.forEach {
        if (it.isNotEmpty()) result += it
        // When empty string is met, 'filterFruits' function stops working immediately.
        // else return

        // When empty string is met, 'filterFruits' function continue working
        // only 'forEach' current iteration is finished like with 'continue' keyword.
        // Use function name as label for return.
        else return@forEach
    }*/

    // #2
    // Use label to return from 'forEach' current iteration.
    fruits.forEach label@{
        if (it.isNotEmpty()) result += it
        else return@label
    }

    println(
        "Fruits after filtering of empty strings: $result"
    )
}