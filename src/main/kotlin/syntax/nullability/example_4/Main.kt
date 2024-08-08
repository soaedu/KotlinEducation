package syntax.nullability.example_4

fun main() {
    val str1 = "abc"
    val str2 = null

    println("Uppercase and print text:" +
        "\n\t'$str1':\t${uppercaseText(str1)}" +
        "\n\t'$str2':\t${uppercaseText(str2)}"
    )
}

fun uppercaseText(s: String?): String {
    // The 'double exclamation' point call the potentially 'nullable' variable
    // Result can be:
    //      * NullPointerException  - if 's' is 'null'
    //      * string value          - if 's' has value
    // val sNotNull: String = s!!.toUpperCase()
    // The 'elvis' operator is used to provide empty row if 's' contains 'null'
    val sNotNull: String = (s ?: "").toUpperCase()
    return sNotNull
}