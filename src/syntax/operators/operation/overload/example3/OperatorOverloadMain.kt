package syntax.operators.operation.overload.example3

import java.math.BigDecimal

/**
 * Унарные арифметические операторы, доступные для перегрузки:
 *  +x          -> unaryPlu
 *  -x          -> unaryMinus
 *  !x          -> not
 *  ++x, x++    -> inc
 *  --x, x--    -> dec
 */
fun main() {
    val point1 = Point(10, 20)
    println("1. point after calling unaryMinus(): ${-point1}")

    var count = 0
    println("2. \tcount after calling post increment operation: ${count++}" +
            "\n\tcount after calling pre increment operation: ${++count}"
    )
}

data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator fun BigDecimal.inc() = this + BigDecimal.ONE