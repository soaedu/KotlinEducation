package syntax.operator.type.equals_operator.example_1

fun main() {
    val a: Int? = 127
    val b: Int? = 127
    println(
        "Show check result of:" +
        "\n\t$a == $b: ${a == b}" +
        "\n\t$a === $b: ${a === b}"
    )

    val c: Int? = 128
    val d: Int? = 128
    println(
        "\nShow check result of:" +
        "\n\t$c == $d: ${c == d}" +
        "\n\t$c === $d: ${c === d}"     // 'new Integer()' was invoked on overflow
    )
}
