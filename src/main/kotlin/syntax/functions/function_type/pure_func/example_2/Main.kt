package syntax.functions.function_type.pure_func.example_2

fun main() {
    val resultData = listOf("USA Dollar", "Canadian dollar", "British Pound")

    println(
        "Call 'pure function' to get currency list: ${getCurrencyList(resultData)}"
    )
}

// Use 'impure function' not ready for easy test.
fun getCurrencies(): List<String> {
    val currencyList = listOf<String>()
    // We have to Mock the API call and get the data (this is a side effect)
    // val result = async repository.getData()
    // do some process here and add currency data

    return currencyList
}

// Use 'pure function' that is easier to test.
// We extract the currency data code 'result' is an input value and create a function
// which gives us the list of currencies.
// See 'test-function' in 'Test' module package 'syntax.functions.function_type.pure_func.example_2'
fun getCurrencyList(result: Any): List<String> {
    val currencyList = mutableListOf<String>()

    if (result is List<*>) {
        currencyList.add(result.first().toString())
    }

    return currencyList
}
