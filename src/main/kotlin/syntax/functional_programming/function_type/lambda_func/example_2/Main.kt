package syntax.functional_programming.function_type.lambda_func.example_2

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    // #1
    // Use variable to assign it a lambda with multiple rows and returning value 'resultList'.
    val filterEvenNumbers: (List<Int>) -> List<Int> = { list: List<Int> ->
        val resultList = mutableListOf<Int>()
        for (item in list) {
            if (item % 2 == 0) resultList += item
        }

        resultList
    }
    println("Print only even numbers: ${filterEvenNumbers(numbers)}")

    // #2
    // Use lambda as an argument for 'filter' function.
    // Parameter inside lambda is names as 'number'.
    println("Print only even numbers: ${numbers.filter { number -> number %2 == 0} }")

    // #3
    // Use lambda as an argument for 'filter' function.
    // Parameter inside lambda is only one that's why we can omit its naming and arrow symbol.
    // Instead, we use implicit parameter 'it'.
    println("Print only even numbers: ${numbers.filter { it %2 == 0} }")
}