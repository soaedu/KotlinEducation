package syntax.nullability.example_1

fun main() {
    // #1
    // The immutable variable is automatically 'non-nullable'.
    val s1 = "abc"

    // #2
    // The immutable variable is declared as 'non-nullable' but null is assigned.
    // This produces: compile-time error 'Null can not be a value of a non-null type String'
    // val s2: String = null

    // #3
    // The immutable variable is declared as 'nullable' and 'null' is assigned.
    val s3: String? = null
    // The immutable variable is declared as 'nullable' and link on 'non-null' variable is assigned.
    val s4: String? = s1

    // #4
    // The immutable variable is declared as 'non-nullable' and link on 'nullable' variable is assigned.
    // This produces: compile-time error: 'Type mismatch: inferred type is String? but String was expected'
    // val s5: String = s4

    // #5
    // The immutable variable is declared and assigned with a link on 'nullable' variable.
    val s6 = s4

    println(
        "Defined variables: " +
        "\n\ts1: $s1" +
        // "\n\ts2: $s2" +
        "\n\ts3: $s3" +
        "\n\ts4: $s4" +
        // "\n\ts5: $s5" +
        "\n\ts6: $s6"
    )
}
