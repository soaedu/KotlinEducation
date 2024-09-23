package syntax.functional_programming.function_type.anonymous_func.lambda_func.example_1

fun main() {
    // #1
    val angleCalculateLambda = { angle: Double -> Math.sin(angle) + Math.cos(angle) }

    val value = Math.PI
    println("Result of calculating angle for value:" +
            "\n\t$value: ${angleCalculateLambda(value)}" +
            "\n\t--------------------------------------" +
            "\n\t$value: ${calculateAngle(value, angleCalculateLambda)}"
    )
}

// #2
fun calculateAngle(angle: Double, f: (Double) -> Double): Double {
    return f(angle)
}