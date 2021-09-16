package data.type.sequence.example3

import kotlin.random.Random

/**
 * Generating a sequence
 */
fun main() {
    val seq = generateSequence { Random.nextInt(5).takeIf { it > 0 } }
    println("1. result: ${seq.toList()}")

    val numbers = generateSequence(3) { n ->
        println("Generating element...")
        (n + 1).takeIf { it < 7 }
    }
    println("2. result: ${numbers.first()}\n")
    println("3. result: ${numbers.toList()}")
}