package data.operations.type_cast.example1

fun main() {

    val userData : Map<String, Any?> = getUserData();

    // если я могу быть уверен что данные есть...просто верни мне тип "String"
    val userName : String = userData["username"] as String

    // если я не могу быть уверен что данные есть...попробуй преобразовать в тип "String", если не получилось
    // верни "null"
    val userAddress : String? = userData["useraddress"] as? String

    // если я не могу быть уверен что данные есть...попробуй преобразовать в тип "String", и:
    //		1. если получилось верни "String"
    // 		2. если не получилось, потому что там "null", то верни "null"
    // 		3. если не получилось, потому что там не строка, то выдай ошибку.
    val userPhone : String? = userData["userphone"] as String?

    println("\nUser data: " +
            "\n\tuserName: $userName" +
            "\n\tuserAddress: $userAddress" +
            "\n\tuserPhone: $userPhone"
    )
}

fun getUserData(): Map<String, Any?> {
    // userPhone: case #1
    // return mapOf("username" to "Bilbo Sumkin", "useraddress" to 1, "userphone" to "123456789") as Map<String, Any?>

    // userPhone: case #2
    // return mapOf("username" to "Bilbo Sumkin", "useraddress" to 1, "userphone" to null) as Map<String, Any?>

    // userPhone: case #3
    return mapOf("username" to "Bilbo Sumkin", "useraddress" to 1, "userphone" to 1) as Map<String, Any?>
}


