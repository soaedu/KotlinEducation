package syntax.operator.type.bitwise_operator.example_2

/**
 * Bitwise operation Java/Kotlin
 *
 * 	Operation					| Java Operator	| Kotlin Int/Long Function
 * ===========================================================================
 * Shift Left					|	a << bits	|	a shl bits
 * Shift Right					|	a >> bits	|	a shr bits
 * Unsigned Shift Right			|	a >>> bits	|	a ushr bits
 */
fun main() {
    val a = 12
    val b = 2
    val c = 3
    val d = 24

    println(
        "Show result of calculation: " +
        "\n\t-$a >> $b == -$c (bitwise right shift, signed): ${-a shr b == -c}" +
        "\n\t-$a >> $b == $c (bitwise right shift, unsigned): ${-a ushr b == c}" +
        "\n\t$c << $c == $d (bitwise left shift): ${c shl c == d}"
    )
}
