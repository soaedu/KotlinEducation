package syntax.functions.function_type.stdlib_func.check_func.example_2

fun main() {
    val intValues = listOf(1, 4, null, 10)
    val stringValues = transformToStrings(intValues)
    println(stringValues)
}

private fun transformToStrings(values: List<Int?>): List<String> {
    val result = mutableListOf<String>()
    for (value in values) {
        // Throw exception:
        //      Exception in thread "main" java.lang.IllegalArgumentException: Value should not be 'null'
        // if 'null' is met.
        requireNotNull(value) { "Value should not be 'null'" }
        result.add(value.toString())
    }
    return result.toList()
}