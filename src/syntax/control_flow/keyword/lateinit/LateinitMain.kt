package syntax.control_flow.keyword.lateinit

fun main(args: Array<String>) {
    val test = SqlTests()
    test.dbConnType = "MySql"

    if (test.hasValue()) {
        println("\nConnection to: ${test.dbConnType}")
    }
}

class SqlTests {
    lateinit var dbConnType: String

    fun hasValue() = this::dbConnType.isInitialized
}