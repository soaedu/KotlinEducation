package unit_testing.test_package

import org.junit.jupiter.api.Test

class DataClassForParameterizedTests {

/*    @Test
    // Which one can fail?
    fun `parse valid tokens`() {
        assertThat(parse("1511443755_2")).isEqualTo(Token(1511443755, "2"))
        assertThat(parse("151175_13521")).isEqualTo(Token(151175, "13521"))
        assertThat(parse("151144375_id")).isEqualTo(Token(151144375, "id"))
        assertThat(parse("1511443759_1")).isEqualTo(Token(1511443759, "1"))
        assertThat(parse(null)).isEqualTo(null)
    }

    data class TestData(
            val input: String?,
            val expectedToken: Token?
    )

    @ParameterizedTest
    @MethodSource("validTokenProvider")
    fun `parse valid tokens`(testData: TestData) {
        assertThat(parse(testData.input).isEqualTo(testData.expectedToken)
    }

    private fun validTokenProvider() = Stream.Of(
        TestData(input = "1511443755_2", expectedToken = Token(1511443755, "2")),
        TestData(input = "151175_13521", expectedToken = Token(151175, "13521")),
        TestData(input = "151144375_id", expectedToken = Token(151144375, "id")),
        TestData(input = "1511443759_1", expectedToken = Token(1511443759, "1")),
        TestData(input = null, expectedToken = null)
    )*/
}

