package syntax.functions.function_type.local_func.example_1

fun main() {
    val x = 10
    val y = 20
    printArea(x, y)
}

// #1
/*fun printArea(width: Int, height: Int): Unit {
    fun calculateArea(width: Int, height: Int): Int = width * height

    // Pass arguments from the 'outer function' to 'local function'
    val area = calculateArea(width, height)
    println("\nThe area is: $area")
}*/

// #2
fun printArea(width: Int, height: Int): Unit {
    // Use directly arguments from the 'outer function' in 'local function'
    fun calculateArea(): Int = width * height
    val area = calculateArea()
    println("\nThe area is: $area")
}