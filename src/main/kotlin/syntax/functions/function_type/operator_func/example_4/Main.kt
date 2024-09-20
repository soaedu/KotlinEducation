package syntax.functions.function_type.operator_func.example_4

import kotlin.random.Random

fun main() {
    // #1
    fun newSeed() = 19357712L      // some secure seed
    val random = RandomLongs(newSeed())
    val longs = listOf(
        random(),
        random(),
        random(),
        random(),
        random()
    )
    println(
        "Generate and display random longs ('invoke' is used):\n\t$longs"
    )

    // #2
    println(
        "\nLook for a minimum value in:" +
        "\n\tintegers (10, 6, 15): ${Min(10, 6, 15)}" +
        "\n\tlongs (3L, 2L, 8L): ${Min(3L, 2L, 8L)}"
    )
}

// #1
class RandomLongs(seed: Long) {
    private val random = Random(seed)

    operator fun invoke(): Long = random.nextLong()
}

// #2
// Use multiple 'invoke' overloaded functions to have variety of calls outside.
object Min {
    operator fun invoke(a: Int, b: Int) = if (a <= b) a else b

    operator fun invoke(a: Int, b: Int, c: Int) = invoke(
        invoke(a, b),
        c
    )

    operator fun invoke(a: Int, b: Int, c: Int, d: Int) = invoke(
        invoke(a, b, c),
        d
    )

    operator fun invoke(a: Long, b: Long) = if (a <= b) a else b

    operator fun invoke(a: Long, b: Long, c: Long) = invoke(
        invoke(a, b),
        c
    )
    operator fun invoke(a: Long, b: Long, c: Long, d: Long) = invoke(
        invoke(a, b, c),
        d
    )
}