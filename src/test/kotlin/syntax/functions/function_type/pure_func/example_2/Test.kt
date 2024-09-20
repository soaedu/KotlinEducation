package syntax.functions.function_type.pure_func.example_2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import syntax.functions.function_type.pure_func.example_1.isAmountValid


class Test {

    // #1
    // Use 'pure function' for test.
    @Test
    fun isValidAmount() {
        val expected = true
        val output = isAmountValid(10.0, 20.0)
        assertEquals(expected, output)
    }

    // #2
   // Use 'impure function' fo test (it depends on the data in 'getCurrencyList' method).
    // Now we can easily test the currency list function.
    @Test
    fun currencyListShouldNotBeEmpty() {
        val resultData = listOf("USA Dollar", "Canadian dollar", "British Pound")
        val currencyList = getCurrencyList(resultData)
        assertEquals(1, currencyList.size)
    }
}
