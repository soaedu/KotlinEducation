package functional_programming.example2

fun main() {
    val result = Evaluation(rightPosition = 1, wrongPosition = 1)
    evaluateGuess("BCDF", "ACEB") eq result
    evaluateGuess("AAAF", "ABCA") eq result
    evaluateGuess("ABCA", "AAAF") eq result
}

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val rightPositions = secret.zip(guess).count { it.first == it.second }
    val commonLetters = "ABCDEF".sumBy { ch ->
        Math.min(secret.count { it == ch }, guess.count { it == ch })
    }

    return Evaluation(rightPositions, commonLetters - rightPositions)
}

infix fun Evaluation.eq(obj: Evaluation) {
    val result = if (rightPosition == obj.rightPosition && wrongPosition == obj.wrongPosition) {
        "OK"
    } else {
        "Error"
    }
    println(result)
}