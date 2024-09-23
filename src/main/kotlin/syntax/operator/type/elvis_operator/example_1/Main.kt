package syntax.operator.type.elvis_operator.example_1

fun main() {
    val word_1: String = "Elvis"
    val word_2: String? = null
    val word_3: String? = null

    println(
        "Show result of:" +
        "\n\t'$word_1' length (no elvis operator): ${if (word_1 != null) word_1.length else -1}" +
        "\n\t'$word_1' length (with elvis operator): ${word_1.length ?: -1}" +
        "\n\t'$word_2' length (no elvis operator): ${if (word_2 != null) word_2.length else -1}" +
        "\n\t'$word_2' length (with elvis operator): ${word_2?.length ?: -1}" +
        "\n\t'$word_2' or '$word_3' length: ${word_2?.length ?: word_3?.length ?: "Both words are null"}"
    )
}
