package syntax.functions.function_type.operator_func.example_7

fun main() {
    // #1
    val numbers = ArrayList<Int>()
    numbers += 1
    println(
        "Print items of the 'numbers' list: $numbers"
    )

    // #2
    val point_1 = Point(10, 20)
    val point_2 = Point(30, 40)
    println(
        "\nCall operator function" +
        "\n\t'plus' using '+': ${point_1 + point_2}" +
        "\n\t'times' using '*' with double scale value for the 'Point' class: ${point_1 * 1.5}" +
        "\n\t'times' using '*' with integer scale value for the 'Char' class: ${'a' * 3}"
    )
}

// #1
// Use 'operator function' as an 'extension function'
operator fun <T> MutableCollection<T>.plusAssign(element: T) {
    this.add(element)
}

// #2
// Define 'operator function' as a 'member function'
data class Point(
    val x: Int,
    val y: Int
) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

// Define 'operator function' as an 'extension function
// Currently is shadowed by the 'plus' function defined as a 'member function' inside 'Point' class
operator fun Point.plus(other: Point): Point {
    return Point(
        this.x + other.x,
        this.y + other.y
    )
}

operator fun Point.times(scale: Double): Point {
    return Point(
        (this.x * scale).toInt(),
        (this.y * scale).toInt()
    )
}

operator fun Char.times(count: Int): String {
    return this.toString().repeat(count)
}
