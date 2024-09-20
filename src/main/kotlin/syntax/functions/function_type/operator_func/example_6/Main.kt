package syntax.functions.function_type.operator_func.example_6

fun main() {
    var counter = Counter(1)

    /*counter_1 = counter_1 + 1
    println(
        "Use operator '+' to increase value:" +
        "\n\tcounter: ${counter_1.k}"
    )*/

    counter += 2
    println(
        "\nUse operator '+=' to increase value:" +
        "\n\tcounter: ${counter.k}"
    )

    counter -= 1
    println(
        "\nUse operator '-=' to decrease value:" +
        "\n\tcounter: ${counter.k}"
    )

    counter *= 1
    println(
        "\nUse operator '*=' to multiply value:" +
        "\n\tcounter: ${counter.k}"
    )

    counter /= 1
    println(
        "\nUse operator '/=' to divide value:" +
        "\n\tcounter: ${counter.k}"
    )

    counter %= 3
    println(
        "\nUse operator '%=' to get remainder:" +
        "\n\tcounter: ${counter.k}"
    )
}

// Both function at the same time can't be defined (ambiguity)
class Counter(var k: Int) {
    // Realisation of increasing value with assignment
    // operator fun plus(j: Int): Counter = Counter(k + j)

    // Use operator function to increase value and assign it at once
    operator fun plusAssign(j: Int) {
        k += j
    }

    operator fun minusAssign(j: Int) {
        k -= j
    }

    operator fun timesAssign(j: Int) {
        k *= j
    }

    operator fun divAssign(j: Int) {
        k /= j
    }

    operator fun rem(j: Int): Counter {
        k %= j
        return this
    }
}