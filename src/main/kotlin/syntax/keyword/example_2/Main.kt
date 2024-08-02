package syntax.keyword.example_2

fun main() {
    // #1
    val percent = 35
    println("Check result: ${checkValue(percent)}")

    // #2
    val values = listOf(1, 3, 5, 7, 9)
    print("\nPrint values with 'for' loop: ")
    printValues(values)

    // #3
    println("\n\nCheck value enter in range result:" +
        "\n\t#1: ${checkValueMembership(values, 7)}" +
        "\n\t#2: ${checkValueMembership(values, 10)}"
    )

    // #4
    val string = "Kotlin"
    val char_1 = 't'
    val char_2 = 'a'
    println(
        "\nCheck character belongs to '$string':" +
        "\n\t$char_1: ${checkCharacterMemberShip(string, char_1)}" +
        "\n\t$char_2: ${checkCharacterMemberShip(string, char_2)}"
    )
}

// #1
// The 'in' keyword tests whether a value is within a range.
fun checkValue(value: Int): Boolean {
    return (value in 1..100)    // is equal to '1 <= percent && percent <= 100'
}

// #2
// The 'in' keyword is used for iteration inside 'for' loop
fun printValues(values: List<Int>) {
    for(value in values) {
        print("\n\t$value")
    }
}

// #3
// The 'in' keyword is used to check membership of a list
fun checkValueMembership(values: List<Int>, value: Int): String {
    val result = if (value in values)
        "is"
    else
        "is not"

    return "$value $result a member of $values"
}


// #4
// The 'in' keyword is used to check whether a character is a part of a string
fun checkCharacterMemberShip(string: String, char: Char): Boolean {
    return char in string
}