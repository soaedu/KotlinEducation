package syntax.nullability.example_6

fun main() {
    val userData: Map<String, Any?> = getUserData(firstLetter = "t")

    // This is a probable place of error:
    //   Exception in thread "main" java.lang.NullPointerException: null cannot be cast to non-null type kotlin.String
    val userName: String = userData["userName"] as String

    // Null can be received and no error will be thrown.
    // if value is:
    //      * null                          - result is 'null'
    //      * string                        - result is string
    //      * some value of the other type  - result is 'null'
    val userAddress: String? = userData["userAddress"] as? String

    // Null can be received and error will be thrown if type can't be cast.
    // if value is:
    //      * null                          - result is 'null'
    //      * string                        - result is string
    //      * some value of the other type  - result is error: Exception in thread "main" java.lang.ClassCastException
    val userPhone: String? = userData["userPhone"] as String?

    println("Filter userData:" +
        "\n\tuserName: $userName" +
        "\n\tuserAddress: $userAddress" +
        "\n\tuserPhone: $userPhone"
    )
}

fun getUserData(firstLetter: String): Map<String, Any?> {
    val map: Map<Int, User> = mapOf(
        1 to User(
            "Andrey",
            "Some address",
            "123456"
        ),
        2 to User(
            "Maxim",
            "Some address",
            "123456"
        ),
        3 to User(
            "Georg",
            "Some address",
            "123456"
        ),
        4 to User(
            // null,
            "Test",
            // null,
            // 123,
            "Some address",
            // null,
            // 123,
            "123456"
        ),
    )

    val result = map.filter { it.value.userName?.firstLetter()?.toLowerCase() == firstLetter }

    val resultMap: MutableMap<String, Any?> = mutableMapOf()
    for (res in result) {
        resultMap["userName"] = res.value.userName
        resultMap["userAddress"] = res.value.userAddress
        resultMap["userPhone"] = res.value.userPhone
    }

    return resultMap
}

fun String.firstLetter() = this.substring(0, 1)

class User(
    val userName: String?,
    val userAddress: String?,
    // val userAddress: Int?,
    val userPhone: String?,
    // val userPhone: Int?,
)