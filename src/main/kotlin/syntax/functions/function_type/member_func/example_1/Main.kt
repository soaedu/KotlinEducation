package syntax.functions.function_type.member_func.example_1

fun main() {
    val rectangle = Rectangle
    rectangle.printArea(10, 20)
}

object Rectangle {
    // Member function declared inside the object
    fun printArea(width: Int, height: Int) {
        val area = calculateArea(width, height)
        println("\nThe area of the rectangle is: $area")
    }

    // Member function declared inside the object
    fun calculateArea(width: Int, height: Int): Int {
        return width * height
    }
}
