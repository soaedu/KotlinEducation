package syntax.control_flow.`when`.example_3

import java.awt.Color

fun main() {
    println(
        "Weather info for a day:" +
        "\n\t#1: ${getWeatherInfo(0)}" +
        "\n\t#2: ${getWeatherInfo(10)}" +
        "\n\t#3: ${getWeatherInfo(35)}"
    )
}

fun getWeatherInfo(degree: Int): String {
    // #1
    /*val (description, color) = when {
        degree < 10 -> Pair("cold", BLUE)
        degree < 25 -> Pair("mild", ORANGE)
        else -> Pair("hot", Color.RED)
    }*/
    // #2
    val (description, color) = when {
        degree < 10 -> "cold" to Color.BLUE
        degree < 25 -> "mild" to Color.ORANGE
        else -> "hot" to Color.RED
    }
    return "$description, color: $color."
}