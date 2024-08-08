package syntax.nullability.example_5

fun main() {
    val s1: String? = null
    val s2 = ""
    val s3: String = " \t\n"

    // Functions from standard library are used to check value.
    //      * isNullOrEmpty() - tests whether the receiver String is null or empty.
    //      * isNullOrBlank() - does the same check as 'isNullOrEmpty()' + consists solely of whitespace characters.
    println(
        "Check values:" +
        "\n\t'${s1}'.isNullOrEmpty(): ${s1.isNullOrEmpty()}" +
        "\n\t'${s1}'.isNullOrBlank(): ${s1.isNullOrBlank()}" +
        "\n\n\t'${s2}'.isNullOrEmpty(): ${s2.isNullOrEmpty()}" +
        "\n\t'${s2}'.isNullOrBlank(): ${s2.isNullOrBlank()}" +
        "\n\n\t'${s3}'.isNullOrEmpty(): ${s3.isNullOrEmpty()} " +
        "\n\t'${s3}'.isNullOrBlank(): ${s3.isNullOrBlank()}"
    )
}