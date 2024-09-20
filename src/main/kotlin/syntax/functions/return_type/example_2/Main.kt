package syntax.functions.return_type.example_2

fun main() {
    // #1
    val value = 64
    println(
        "Show result of Math.sqrt on: " +
        "\n\tpositive value (single value): ${positiveRoot(value)}" +
        "\n\tnegative value (single value): ${negativeRoot(value)}" +
        "\n\tpositive + negative values (array with values): ${roots_1(value).toList()}"
    )

    // #2
    val (posFromRoot, negFromRoot) = roots_2(value)
    println(
        "\nShow result of Math.sqrt on class 'Root': " +
        "\n\tpositive + negative values: ${roots_2(value)}" +
        "\n\tdestructuring declaration: $posFromRoot, $negFromRoot"
    )

    // #3
    val (posFromPair, negFromPair) = roots_3(value)
    println(
        "\nShow result of Math.sqrt on function 'Pair': " +
        "\n\tpositive + negative values: ${roots_3(value)}" +
        "\n\tdestructuring declaration: $posFromPair, $negFromPair"
    )
}

// #1
// USe functions that returns result as single value of type 'Double'.
fun positiveRoot(k: Int): Double {
    require(k >= 0)
    return Math.sqrt(k.toDouble())
}
fun negativeRoot(k: Int): Double {
    require(k >= 0)
    return -Math.sqrt(k.toDouble())
}
// Use function that returns result as array with multiple values of type 'Double'.
fun roots_1(value: Int): Array<Double> {
    require(value >= 0)
    val root = Math.sqrt(value.toDouble())

    return arrayOf(root, -root)
}

// #2
// Use class 'Root' to improve readability of the text and use
// explicit parameters for values
class Root(val pos: Double, val neg: Double) {
    override fun toString(): String {
        return "Root(pos=$pos, neg=$neg)"
    }

    operator fun component1(): Double {
       return pos
    }

    operator fun component2(): Double {
       return neg
    }
}
fun roots_2(value: Int): Root {
    require(value >= 0)
    val root = Math.sqrt(value.toDouble())

    return Root(root, -root)
}

// #3
// Use function from the standard library 'Pair'
// to return two values at once.
fun roots_3(value: Int): Pair<Double, Double> {
    require(value >= 0)
    val root = Math.sqrt(value.toDouble())

    return Pair(root, - root)
}
