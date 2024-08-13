package syntax.functions.function_type.generic_func.example_1

import java.util.*

fun main(args: Array<String>) {
    // #1
    val wordToPrint = "Hey"
    var repeatTimes = 5
    println("\nPrint '$wordToPrint' $repeatTimes times:")
    printRepeated(wordToPrint, repeatTimes)

    val numberToPrint = 100
    repeatTimes = 2
    println("\nPrint '$numberToPrint' $repeatTimes times:")
    printRepeated(numberToPrint, repeatTimes)

    // #2
    println("\nChoosing the number from {5, 7, 9} ..." +
            "\nResult is: ${choose(5, 7, 9)}")
}

// #1
// The 'generic' function is used to print value in 't' variable 'k' times.
fun <T> printRepeated(t: T, k: Int): Unit {
    for (x in 1..k) {
        println(t)
    }
}

// #2
// The 'generic' function is used to print randomly one of the
// values passed in arguments: 't1', 't2', 't3'.
fun <T> choose(t1: T, t2: T, t3: T): T {
    return when (Random().nextInt(3)) {
        0 -> t1
        1 -> t2
        else -> t3
    }
}
