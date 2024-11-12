package coroutines.example_6

import kotlinx.coroutines.*
import java.io.InputStream

/**
 * Errors in coroutines.
 *
 * To handle an error we should use 'try-catch' block.
 */
suspend fun main() {
    coroutineScope {
        // #1
        // Use 'launch' to handle an error.
        // Handles appeared error inside the 'launch'.
        // Important: If error appear, it is handled inside 'launch' and
        // 'coroutineScope' continue to work.
        launch {
            try {
                doSomething()
            } catch (e: Exception) {
                println("\nHandle error inside launch")
            }
        }

        // #2
        // Use 'async' to handle an error.
        // Error should be handled by those who call this code
        // Important: Even when we handle an error appeared in 'async' we get
        // stop of 'coroutineScope'.
//        val deferred: Deferred<Unit> = async {
//            doSomething()
//        }
//        try {
//            deferred.await()
//        } catch(e: Exception) {
//            println("Handle error inside async")
//        }

        // #3
        val job = async(start = CoroutineStart.LAZY) {
            try {
                doSomething()
            } catch (ec: CancellationException) {
                println("\nHandle error inside async (cancel)")
            } catch (e: Exception) {
                println("\nHandle error inside async (exception)")
            }
        }
        job.invokeOnCompletion { cause: Throwable? ->
            if (cause != null) {
                println("Error: ${cause.message}")
            } else {
                println("Coroutine complete")
            }
        }
        job.join()

        // #4
        // Use 'finally' sub-block to execute a suspend-function after
        // error handle
        val inputStream = object: InputStream() {
            override fun read(): Int {
                return 0
            }
        }
        val loadingJob = launch(start = CoroutineStart.LAZY) {
            try {
                load(inputStream)
            } catch (e: Exception) {
                println("Handle error (launch#2)")
            } finally {
                withContext(NonCancellable) {
                    shutdown(inputStream)
                }
            }
        }
        loadingJob.join()
    }

    val exceptionHandler = CoroutineExceptionHandler { context, error: Throwable ->
        logError(error.message ?: "Error without message")
    }
    // #5
    // Use 'CoroutineExceptionHandler' to handle errors inside coroutine
    // Specifying it in 'CoroutineScope' on declaration.
    val coroutineScopeWithErrorHandler = CoroutineScope(exceptionHandler)
    coroutineScopeWithErrorHandler.launch {
        doSomething()
    }

    // #6
    // Use 'CoroutineExceptionHandler' to handle errors inside coroutine
    // Specifying it in 'launch' on declaration.
    coroutineScope {
        launch(exceptionHandler) {
            doSomething()
        }
    }
}

private suspend fun doSomething() {
    for (i in 1..10) {
        delay(1000)
        print("$i ")

        // if (i == 3) throw CancellationException("User cancel process")
        if (i == 3) throw Exception("User cancel process")
    }
}

private suspend fun load(inputStream: InputStream) {
    println("Load data...")
    delay(1000)
    throw CancellationException("Server not found some files.")
}

private fun logError(error: String) {
    println("Log error: $error")
}

private fun shutdown(inputStream: InputStream) {
    println("Finish loading data. Close InputStream.")
}
