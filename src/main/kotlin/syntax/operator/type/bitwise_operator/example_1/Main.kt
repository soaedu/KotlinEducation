package syntax.operator.type.bitwise_operator.example_1

/**
 * Bitwise operation Java/Kotlin
 *
 * Operation					| Java Operator	| Kotlin Int/Long Function
 * ===========================================================================
 * Conjunction (and)			|	a & b		|	a and b
 * Disjunction (or)				|	a | b		|	a or b
 * Exclusive disjunction (xor)	|	a ^ b		|	a xor b
 * Inversion					|	~ a			|	a.inv()
 */
fun main() {
    val a = 0b10011     // 19
    val b = 0b11110     // 30
    val c = 0b10010     // 18
    val d = 0b11111     // 31
    val e = 0b01101     // 13

    println(
        "Show result of calculation:" +
        "\n\t$a and $b == $c (bitwise conjunction): ${a and b == 0b10010}" +
        "\n\t$a or $b == $d (bitwise disjunction): ${a or b == d}" +
        "\n\t$a xor $b == $e (bitwise exclusive disjunction): ${a or b == e}" +
        "\n\t~$a (bitwise inversion): ${a.inv()}"
    )
}
