package data.type.sequence.example4

/**
 * yield - can be used to create a sequence.
 *          Is not a built-in feature of the Kotlin language. It's a regular library function.
 *
 * Other generate sequence functions are quit constraint. The lambda there generates a sequence element must be
 * either based on external sources or based on the previous element, but you cannot really customize that.
 * With yield, you can generate any elements in any convenient order.
 *
 * sequence {
 *      yield(value)
 *      doSomeThing()
 *      yieldAll(list)
 *      doSomeThingElse()
 *      yield(sequence)
 * }
 */
fun main() {
    val numbers = sequence {
        var x = 0
        while(true) {
            yield(x++)
        }
    }

    println("1. result: ${numbers.take(5).toList()}\n")


    fun mySequence() = sequence {
        println("yield one element")
        yield(1)
        println("yield a range")
        yieldAll(3..5)
        println("yield a list")             // won't be
        yieldAll(listOf(7, 9))              // called
    }

    println("2. result: ${mySequence()      // 1  3  4
        .map { it * it }                    // 1  9  16
        .filter { it > 10 }                 // -  -  16
        // .take(1)}"                       // Is not a terminal operation!
        .first()}"                          // Is a terminal operation!
    )
}