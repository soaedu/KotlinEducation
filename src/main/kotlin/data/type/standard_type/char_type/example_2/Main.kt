package data.type.standard_type.char_type.example_2

fun main() {
    // #1
    // Use 'char' to print a string letters in 'for' cycle one by one
    val string = "Alphabet"

    println("Show letters for:" +
        "\n\t'Alphabet' one by one"
    )
    for (char in string) {
        print("\t\t$char")
    }

    // #2
    // Use 'char' as a return type of the method, to get the first letter of the string
    fun showFirstCharacter(input: String): Char {
        if(input.isEmpty()) throw IllegalArgumentException()

        return input.first()
    }
    println("\n\nShow letter for:" +
            "\n\t'Alphabet': ${showFirstCharacter("Alphabet")}"
    )
}
