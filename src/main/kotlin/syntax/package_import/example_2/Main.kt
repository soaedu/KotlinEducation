package syntax.package_import.example_2

// #2
//import kotlin.math.PI
//import kotlin.math.cos  // Cosine

// #3 (Import everything from a package)
import kotlin.math.*

// #4
import syntax.package_import.example_2.pythagorean.RightTriangle

fun main() {
    // #1
    // Using fully qualifying import in the body of the code.
    println(kotlin.math.PI)
    println(kotlin.math.cos(kotlin.math.PI))
    println(kotlin.math.cos(2 * kotlin.math.PI))

    // #2
    // Using 'import' to shorten the code.
    println()
    println(PI)
    println(cos(PI))
    println(cos(2 * PI))

    // #4
    // Using 'import' keyword to enable class from the 'pythagorean' package.
    println()
    val rt = RightTriangle(3.0, 4.0)
    println(rt.hypotenuse())
    println(rt.area())
}