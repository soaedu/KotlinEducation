package coroutines.example_3

import kotlinx.coroutines.*

/**
 * Recommendations related to 'launch':
 *      * use it for 'fire-and-forget' tasks and/or for tasks that don't
 *          need to return a value.
 *      * handle explicitly any exception that can occur within the launched
 *          coroutine to avoid application crash.
 *      * use it to run coroutines concurrently, allowing them to execute
 *          simultaneously.
 *      * use it for concurrently running multiple coroutines since it doesn't
 *          wait for any result.
 *      * use it to avoid overhead of returning and handling a 'Deferred' result
 *          because it is more lightweight in terms of performance.
 *      * use it if is required check of the running coroutine(s), because it
 *          returns a 'Job'.
 *      * use it if result of the 'launch' block is not required to be used
 *          outside the 'coroutine' block and is used only for side effects.
 *      * it is generally safer for usage, because it is a part of structured
 *          concurrency. It is tied to a specific 'CoroutineScope'.
 */
suspend fun main() {
    val range_1 = 1..5
    val range_2 = 6..10

    // #1
    // Use 'coroutineScope' and 'launch' to create a coroutine.
    coroutineScope {
        // launch { executeTwoCoroutinesWithLaunch(listOf(range_1, range_2)) }
        executeTwoCoroutinesWithLaunch(listOf(range_1, range_2))
    }

    // #2
    // Use 'coroutineScope' and 'launch' with 'try-catch' block
    // to handle an exception
    coroutineScope {
        launch {
            try {
                throw RuntimeException("Oops! This is a 'launch' exception.")
            } catch (e: Exception) {
                println("\nException: ${e.message}")
            }
        }
    }

    // #3
    // Use 'coroutineScope' and 'launch' to create a tree of coroutines.
    coroutineScope {
        launch {
            println("Outer coroutine")
            launch {
                println("Inner coroutine")
                delay(400L)
            }
        }

        println("\nEnd of 'main'")
    }

    // #4
    // Use 'coroutineScope' and 'launch' to create a coroutine,
    // specifying explicitly context
    coroutineScope {
        launch(context = Job() + Dispatchers.IO) {
            println("\nCoroutine context: ${this.coroutineContext}")
        }
    }

    // #5
    // Use 'coroutineScope' and 'launch' to create a coroutine,
    // specifying explicitly a custom name
    coroutineScope {
        launch(CoroutineName("LongTask")) {
            delay(10000)
            println("\nI'm working in thread ${Thread.currentThread().name} and use custom name for coroutine")
        }
    }

    // #6
    // Use 'coroutineScope' and 'launch' to create a coroutine with lazy start
    // (execution will be performed when 'start'/'await' is met)
    coroutineScope {
        val launchSumResult = launch (start = CoroutineStart.LAZY) {
            val result = sum(1, 2)
            println("sum: $result")
        }

        delay(1000L)
        println("\nActions after the coroutine creation")

        // Start and execute coroutine
        launchSumResult.start()
    }

    // #7
    // Use 'coroutineScope' and 'launch' to create a coroutine,
    // start and then stop it
    coroutineScope {
        val downloadJob = launch {
            try {
                println("\nStart downloading files...")
                for (i in range_1) {
                    println("Downloading file #$i")
                    delay(500L)
                }
            }
            catch (e: CancellationException) {
                println("Download is interrupted")
            } finally {
                println("Download is complete")
            }
        }

        // Set delay for downloading few files
        delay(800L)
        println("Client decided to interrupt downloading files.")

        // Stop coroutine
        //downloadJob.cancel()
        // Wait until coroutine will end up
        //downloadJob.join()

        // Combine methods 'cancel' and 'join' into 'cancelAndJoin()'
        downloadJob.cancelAndJoin()

        println("Coroutine is stopped.")
    }

    // #8
    // Use 'coroutineScope' and 'launch' to create a coroutine,
    // specifying explicitly the dispatcher
    coroutineScope {
        // launch(Dispatchers.IO) {
        // launch(Dispatchers.Unconfined) {
        // launch(newSingleThreadContext("Custom Thread")) {
        launch(newFixedThreadPoolContext(2, "Fixed Pool")) {
            println("\nCoroutine thread (before stop): ${Thread.currentThread().name}")
            delay(500L)
            println("Coroutine thread (after stop): ${Thread.currentThread().name}")
        }
        println("\n'main' function thread: ${Thread.currentThread().name}")
    }

    // #9
    // Use 'runBlocking' and 'launch' to create a coroutine
    val range = 1..5
    println("\nexecuteCoroutineWithRunBlocking start")
    executeCoroutineWithRunBlocking(range)
    println("executeCoroutineWithRunBlocking end")
}

private fun greet() = println("Hello Coroutines")

suspend fun doWork(range: IntRange) {
    for (i in range) {
        delay(400L)
        println(i)
    }
}

fun executeCoroutineWithRunBlocking(range: IntRange) = runBlocking {
    launch { coroutines.example_1.doWork(range) }
    greet()
}

// Execution will be parallel
suspend fun executeTwoCoroutinesWithLaunch(ranges: List<IntRange>) = coroutineScope {
    launch {
        doWork(ranges.first());
        println("launch#1 thread: ${Thread.currentThread().name}")
    }
    launch {
        doWork(ranges.last());
        println("launch#2 thread: ${Thread.currentThread().name}")
    }
    greet()
}

private fun sum(value_1: Int, value_2: Int): Int {
    println("Coroutine has started")
    return value_1 + value_2
}
