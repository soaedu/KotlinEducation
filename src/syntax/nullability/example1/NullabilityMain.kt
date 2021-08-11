package syntax.nullability.example1

fun main() {
    val nullString = null
    val valuedString = "Test"

    println("The first letter of the string:" +
            "\n\t\"nullString\" is: ${shorten(nullString)}" +
            "\n\t\"valuedString\" is: ${shorten(valuedString)}"
    )
}

fun shorten(name: String?): String =
        if (true == name?.isNotEmpty()) name[0] + "."
        else ""