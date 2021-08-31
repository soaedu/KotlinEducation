package syntax.control_flow.if_else.example2

import java.awt.Color
import java.awt.Color.BLUE
import java.awt.Color.ORANGE

fun main() {
    print("1. weather info: ")
    updateWeather(8)

    print("\n2. weather info:")
    updateWeather(18)

    print("\n3. weather info:")
    updateWeather(28)
}

fun updateWeather(degree: Int) {
    // #1
    /*val (description, color) = when {
        degree < 10 -> Pair("cold", BLUE)
        degree < 25 -> Pair("mild", ORANGE)
        else -> Pair("hot", Color.RED)
    }*/
    // #2
    val (description, color) = when {
        degree < 10 -> "cold" to BLUE
        degree < 25 -> "mild" to ORANGE
        else -> "hot" to Color.RED
    }
    print("\n\tdescription: $description, color: $color")
}