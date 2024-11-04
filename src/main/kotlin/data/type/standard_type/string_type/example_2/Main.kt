package data.type.standard_type.string_type.example_2

fun main() {
    // #1
    val rawString = """
        This is a raw "string"
        it \should be printed as-is"""
    println("\nRaw string $rawString")

    // #2
    // Produces compile error: 'Unresolved reference tring'
    // $tring templates shall not pass!
    // So we have to include dollar sign in to expression
    val rawStringWithDollar = """        
        ${'$'}tring templates shall not pass!
    """
    println(
        "Show raw string with '$' sign inside: $rawStringWithDollar"
    )
    val kotlinLogo = """| //
                       .|//
                       .|/ \"""
    println(
        "Show Kotlin logo excluding prefix and margins in each row with 'trimMargin':" +
        "\n${kotlinLogo.trimMargin(".")}"
    )

    // #3
    val stringToSplit = "12.345-6.A"
    val result_1 = stringToSplit.split("\\.|-".toRegex())
    val result_2 = stringToSplit.split(".")
    val result_3 = stringToSplit.split(".", ",")
    val result_4 = stringToSplit.split(".", "-")
    println(
        "\nShow result of regular expression apply:" +
        "\n\texplicit transmission: $result_1" +
        "\n\tsingle delimiter transmission: $result_2" +
        "\n\tfew delimiters transmission (#1): $result_3" +
        "\n\tfew delimiters transmission (#2): $result_4"
    )

    // #4
    val targetValue_1 = "."
    val targetValue_2 = "/"
    val path = "/User/AppData/doc/TextFile.doc"
    val result_5 = path.substringAfter(targetValue_1)
    val result_6 = path.substringAfterLast(targetValue_2)
    val result_7 = path.substringBefore(targetValue_1)
    val result_8 = path.substringBeforeLast(targetValue_2)
    println(
        "\nShow result of substring receiving with:" +
        "\n\t'substringAfter' a value '$targetValue_1': $result_5" +
        "\n\t'substringAfterLast' value '$targetValue_2': $result_6" +
        "\n\t'substringBefore' value '$targetValue_1': $result_7" +
        "\n\t'substringBeforeLast' value '$targetValue_2': $result_8"
    )
}
