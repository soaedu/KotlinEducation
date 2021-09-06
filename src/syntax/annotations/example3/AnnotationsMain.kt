package syntax.annotations.example3

fun main() {

}

// #1
//object SuperComputer {
//    val answer = 42
//}

// #2
//object SuperComputer {
//    @JvmStatic
//    val answer = 42
//}

// Exposing the field for all types of data
// #3
//object SuperComputer {
//    @JvmField
//    val answer = 42
//}

// Exposing the field for primitive and String type data
// #4
object SuperComputer {
    const val answer = 42
}

/**
 * Top level property
 */
// #5
// val answer = 42

// #6
//@JvmField
//val answer = 42

// #7
const val answer = 42