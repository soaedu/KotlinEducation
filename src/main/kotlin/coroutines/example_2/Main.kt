package coroutines.example_2

import coroutines.example_3.doWork
import kotlinx.coroutines.*

/**
 * Coroutines can be created inside one of the coroutine scopes:
 *      * CoroutineScope    - doesn't block thread, only suspends execution
 *                              releasing the thread for other resources.
 *                              Can be applied to any function.
 *      * GlobalScope       - is not tied to any Job.
 *                              All coroutines started inside this scope will
 *                              work until they will be stopped or process stop.
 *                              Is not recommended for wide usage and is marked
 *                              with annotation '@DelicateCoroutinesApi'.
 *      * runBlocking       - blocks running thread until all coroutines inside
 *                              will finish their work.
 *
 * Recommendations about using 'async':
 *      * use it only when the parallel execution of different tasks is required
 *          as it waits for all the tasks to be completed.
 *      * use it when the result of a background computation is required, and we
 *          want to asynchronously retrieve it.
 *      * use it for concurrent computations and aggregating results.
 *      * use it when we need the result of one coroutine to proceed with another.
 *      * use it if an overhead due to the need to create and manage 'Deferred'
 *          objects is not critical for performance.
 */
@OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
suspend fun main() {
    // #1
    // Use 'CoroutineScope' to create a scope of coroutines
    val coroutineScope = CoroutineScope(Job() + Dispatchers.Default)
    val result = coroutineScope.async {
        "Coroutine with async"
    }
    println(result.await())

    // #2
    // Use 'coroutineScope' to create a scope and start few coroutines inside
    // at once (parallel)
    coroutineScope {
        val range_1 = 1..5
        val range_2 = 6..10
        executeTwoCoroutinesWithAsync(listOf(range_1, range_2))
    }

    println()

    // #2
    // Use 'GlobalScope' and 'async' to create a coroutine.
    // Coroutines are created and start their execution all in one moment
    // but their results are printed only after 'await' call.
    runBlocking {
        val result_1 = GlobalScope.async {
            delay(1000L)
            "Async: Text #1"
        }
        val result_2 = coroutineScope {
            async {
                delay(3000L)
                "Async: Text #2"
            }
        }
        val result_3 = coroutineScope {
            async {
                delay(2000L)
                "Async: Text #3"
            }
        }
        println(result_1.await())
        println(result_2.await())
        println(result_3.await())
    }

    // #2
    // Tasks are executed in parallel but result will be printed
    // after heavier task complete.
    runBlocking {
        println("\nFirst statement of 'async'")
        launch {
            val async_1 = async { executeCoroutineWithAsync_1() }
            val async_2 = async { executeCoroutineWithAsync_2() }
            val result = if (async_1.await() && async_2.await()) {
                "Both returned 'true'"
            } else {
                "Someone returned 'false'"
            }
            println(result)
        }
        println("Last statement of 'async'")
    }

    // #3
    // Use 'try-catch' block around the 'await' call to handle potential
    // exceptions gracefully. Otherwise, the exception will be silently
    // swallowed.
    runBlocking {
        val deferred = GlobalScope.async {
            throw RuntimeException("Oops! This is an 'async' exception.")
        }
        try {
            deferred.await()
        } catch (e: Exception) {
            println("\nCaught 'async' exception: ${e.message}")
        }
    }

    // #4
    // Use 'async' to create a non-blocking coroutine that introduces
    // suspension point when we 'await' the result.
    println()
    runBlocking {
        val deferred_1 = async(newFixedThreadPoolContext(4, "pool")) {
            delay(1000L)
            "Async #1 completed"
        }
        val deferred_2 = async(newSingleThreadContext("Custom thread")) {
            delay(1000L)
            "Async #2 completed"
        }
        println("This is not blocked")

        // This will suspend the coroutine until the result is available
        val result_1 = deferred_1.await()
        println(result_1)

        val result_2 = deferred_2.await()
        println(result_2)
    }

    // #5
    // Use 'async' to create a coroutine with lazy start
    // (execution will be performed when 'start'/'await' is met)
    coroutineScope {
        val asyncSumResult = async(start = CoroutineStart.LAZY) { sum(1, 2) }

        delay(1000L)
        println("\nActions after the coroutine creation")

        // Start and execute coroutine before 'await'
        asyncSumResult.start()

        println("sum: ${asyncSumResult.await()}")
    }

    // #6
    // Use 'async' to create a coroutine, start it and then stop its work
    coroutineScope {
        val asyncDownloadResult = async {
            println("\nStart downloading files...")
            for (i in 1..5) {
                println("Downloading file #$i")
                delay(500L)
            }
        }

        // Set delay for downloading few files
        delay(800L)
        println("Client decided to interrupt downloading files.")

        // Stop coroutine
        //asyncDownloadResult.cancel()
        // Wait until coroutine will end up
        //asyncDownloadResult.join()

        // Combine methods 'cancel' and 'join' into 'cancelAndJoin()'
        asyncDownloadResult.cancelAndJoin()

        println("Coroutine is stopped.")
    }

    // #7
    // Use 'async' to create a coroutine and specify explicitly dispatcher
    coroutineScope {
        val asyncResult = async(Dispatchers.Unconfined) {
            println("\nCoroutine thread (before stop): ${Thread.currentThread().name}")
            delay(500L)
            println("Coroutine thread (after stop): ${Thread.currentThread().name}")
        }
        println("'main' function thread: ${Thread.currentThread().name}")
    }
}

private fun greet() = println("Hello Coroutines")

private suspend fun executeCoroutineWithAsync_1(): Boolean {
    delay(1000L)
    return true
}
private suspend fun executeCoroutineWithAsync_2(): Boolean {
    delay(3000L)
    return false
}

// Execution will be sequential
suspend fun executeTwoCoroutinesWithAsync(ranges: List<IntRange>) = coroutineScope {
    val firstAsyncResult = async {
        doWork(ranges.first());
        println("async#1 thread: ${Thread.currentThread().name}");
        "First async complete"
    }.await()
    println(firstAsyncResult)

    val secondAsyncResult = async {
        doWork(ranges.last());
        println("async#2 thread: ${Thread.currentThread().name}");
        "Second async complete"
    }.await()
    println(secondAsyncResult)

    greet()
}

private suspend fun sum(value_1: Int, value_2: Int): Int {
    println("Coroutine has started")
    return value_1 + value_2
}

