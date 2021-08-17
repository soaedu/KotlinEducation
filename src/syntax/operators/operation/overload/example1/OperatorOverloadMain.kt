package syntax.operators.operation.overload.example1

/**
 * Бинарные арифметические операторы, доступные для перегрузки:
 *  x*y     -> times
 *  x/y     -> div
 *  x%y     -> mod
 *  x+y     -> plus
 *  x-y     -> minus
 *
 *  Операторы + и - всегда возвращают новую коллекцию.
 */
fun main() {
    val point1 = Point(10, 20)
    val point2 = Point(30, 40)

    // Вызов функции «plus» путем использования оператора "+"
    println("1. point1 + plus2: ${point1 + point2}")

    println("2. scale point1 on 1.5: ${point1 * 1.5}")

    println("3. print <a> 3 times: ${'a' * 3}")
}

/**
 * Определение оператора "plus"
 */
data class Point(val x: Int, val y: Int) {
    // Определение функции с именем «plus», реапизующее оператор
    operator fun plus(other: Point): Point {
        // Скпадывает координаты и возвращает новую точку
        return Point(x + other.x, y + other.y)
    }
}

/**
 * При наличии такого же метода в классе, будет вызван тот, что внутри класса
 */
operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}

operator fun Point.times(scale: Double): Point {
    return Point(
        (x * scale).toInt(),
        (y * scale).toInt()
    )
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}