package syntax.nullability.example_2

fun main() {
    // #1
    // The immutable variable is defined as 'nullable' and 'null' is assigned.
    val nullString: String? = null
    // This produces compile-error:
    //      'Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?'
    // nullString.length

    // #2
    // The immutable variable is defined as 'non-nullable' and text is assigned.
    val valuedString = "Test"
    println("The first letter of the string:" +
        "\n\t\"nullString\" is: ${shorten(nullString)}" +
        "\n\t\"valuedString\" is: ${shorten(valuedString)}"
    )

    // #3
    println("\nPrint value with all cap: ")
    printAllCaps(null)
    printAllCaps("abc")
}

fun shorten(name: String?): String {
    // Safe call operator is used to check if 'name' has value because it can be 'null'.
    return if (true == name?.isNotEmpty())
        name[0] + "."
    else
        ""
}

fun printAllCaps(s: String?) {
    // #3
    // The immutable property is defined as 'nullable' String type and is assigned with:
    // null                 - if 's' is null
    // 's' value uppercase  - if ot is not null
    val allCaps: String? = s?.toUpperCase()
    println("\t$s: $allCaps")
}
