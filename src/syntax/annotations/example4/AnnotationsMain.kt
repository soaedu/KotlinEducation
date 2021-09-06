package syntax.annotations.example4

fun main() {
    println("1. average of ints: ${listOf(1, 2, 3, 4).average()}")
    println("2. average of doubles: ${listOf(1.0, 2.0, 3.0, 4.0).average()}")
}

fun List<Int>.average(): Double {
    val totalSum = this.reduce { accumulator, i -> (accumulator + i) }

    return (totalSum / this.size).toDouble()
}

@JvmName("averageOfDouble")
fun List<Double>.average(): Double {
    val totalSum = this.reduce { accumulator, i -> (accumulator + i) }

    return (totalSum / this.size)
}