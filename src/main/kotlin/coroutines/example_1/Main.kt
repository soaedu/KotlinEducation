package coroutines.example_1

import kotlinx.coroutines.*

/**
 * Coroutines can be built using one of the coroutine builders:
 *      * async         - used to start a coroutine that returns a 'Deferred'
 *                          value. To get the result from 'Deferred' we should
 *                          call 'await'.
 *      * launch        - used to start a new coroutine that doesn't return a
 *                          result.
 */
suspend fun main() {
    val range = 1..5

    // #1
    // Use 'coroutineScope' and 'async' to create a coroutine
    println("executeCoroutineWithAsync start")
    val deferredResult = executeCoroutineWithAsync(range)
    println(deferredResult.await())
    println("executeCoroutineWithAsync end")

    // #2
    // Use 'coroutineScope' and 'launch' to create a coroutine
    println("\nexecuteCoroutineWithLaunch start")
    executeCoroutineWithLaunch(range)
    println("executeCoroutineWithLaunch end")
}

private fun greet() = println("Hello Coroutines")

suspend fun doWork(range: IntRange) {
    for (i in range) {
        delay(400L)
        println(i)
    }
}

suspend fun executeCoroutineWithAsync(range: IntRange) = coroutineScope {
    async {
        doWork(range)
        greet()
        "Coroutine execution is completed"
    }
}

suspend fun executeCoroutineWithLaunch(range: IntRange) = coroutineScope {
    launch { doWork(range) }
    greet()
}
