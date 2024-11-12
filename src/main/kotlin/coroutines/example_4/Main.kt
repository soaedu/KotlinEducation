package coroutines.example_4

import coroutines.example_3.doWork
import kotlinx.coroutines.*
import kotlin.coroutines.ContinuationInterceptor

/**
 * 'Job' is the task that is executed in the background. It helps to manage
 * coroutine work (cancel it).
 *
 * Using 'Job' we can create a hierarchy 'Parent - Child'.
 *
 * Lifecycle of the 'Job' has few states:
 *      * new           - it is created
 *      * active        - it is started
 *      * completing    - execution finishes successfully and child coroutines
 *                          finish is awaited
 *      * completed     - execution finished successfully and all child coroutines
 *                          finished successfully
 *      * cancelling    - during execution an error appeared or cancel was invoked
 *      * cancelled     - execution was finished unsuccessfully
 *
 *  Methods of the 'Job':
 *      * cancel                - cancel Job execution (cause of the cancel can be passed
 *                                  as a parameter)
 *      * ensureActive          - check if current Job is active, if it is not,
 *                                  'CancellationException' will be thrown
 *      * invokeOnCompletion    - allows to set callback that will be executed
 *                                  on Job execution finish
 *      * join                  - suspends coroutine execution and awaits Job
 *                                  execution
 *      * start                 - starts execution of the coroutine that is bound
 *                                  to that Job (if it is not already started)
 *
 *  Properties of the 'Job':
 *      * children      - provides access to all child Jobs
 *      * isActive
 *      * isCancelled
 *      * isCompleted
 *
 *  When parent 'Job' is cancelled recursive cancellation of child 'Jobs' will
 *  happen.
 *
 *  When child 'Job' was cancelled or an error during execution appeared, will
 *  invoke cancelling of the parent 'Jobs' and these parent 'Jobs' will
 *  terminate all their child coroutines.
 *
 *  We can use 'SupervisorJob' to avoid cancellation of the child coroutines
 *  by parent coroutines when one of the child coroutine in the hierarchy invoke
 *  cancellation.
 */
suspend fun main() {
    val range_1 = 1..5
    val range_2 = 6..10

    println("----------------------- #1 ---------------------")
    // #1
    // Use 'coroutineScope' and 'launch' to create a tree of coroutines.
    coroutineScope {
        val parentJob = launch {
            // Get 'Job' from 'coroutineContext' and show its info
            val firstLaunchJob = coroutineContext[Job]
            println("Show 'firstLaunchJob' info: ${firstLaunchJob.toString()}")

            // Start executing two coroutines
            executeTwoCoroutinesWithLaunch(listOf(range_1, range_2))
        }

        // Wait one second and finish all children coroutines
        delay(1000)
        parentJob.cancelChildren()
        println(
            "\nShow 'parentJob' info:" +
            "\n\tisActive: ${parentJob.isActive}" +
            "\n\tisCancelled: ${parentJob.isCancelled}" +
            "\n\tisCompleted: ${parentJob.isCompleted}"
        )

        // Try to start coroutine execution after 'CoroutineScope' cancel performed.
        // Error: 'Exception in thread "main" kotlinx.coroutines.JobCancellationException:
        //          ScopeCoroutine was cancelled; job=ScopeCoroutine{Cancelled}@5479e3f'
        /*
        this.cancel()
        executeTwoCoroutinesWithLaunch(listOf(range_1, range_2))
         */
    }

    println("\n----------------------- #2 ---------------------")
    // #2
    // Use 'withContext' to switch a context for a code inside another coroutine
    // with already specified context.
    coroutineScope {
        launch(Dispatchers.Unconfined) {
            val firstDispatcher = coroutineContext[ContinuationInterceptor]!!
            println("First coroutine dispatcher: $firstDispatcher")
            loadRemote()
        }
    }

    println("\n----------------------- #3 ---------------------")
    // #3
    // Use 'cancel' to stop child coroutines work inside parent (scope)
    val scope_1 = CoroutineScope(Dispatchers.IO)
    scope_1.launch {
        delay(100)
        println("The 'job_1' is started.")
    }.invokeOnCompletion {
        println("'job_1' is completed. $it")
    }
    scope_1.launch {
        delay(100)
        println("The 'job_2' is started.")
    }.invokeOnCompletion {
        println("'job_2' is completed. $it")
    }
    scope_1.cancel()
    println("'scope_1' is active: ${scope_1.isActive}")

    println("\n----------------------- #4 ---------------------")
    // #4
    // Use 'cancel' to stop only child coroutine and continue work of parent (scope)
    val scope_2 = CoroutineScope(Dispatchers.IO)
    val job_3 = scope_2.launch {
        delay(100)
        println("The 'job_3' is started.")
    }
    job_3.invokeOnCompletion {
        println("The 'job_3' is completed.")
    }
    val job_4 = scope_2.launch {
        delay(100)
        println("The 'job_4' is started.")
    }
    job_4.invokeOnCompletion {
        println("The 'job_4' is completed.")
    }
    job_4.cancel()
    println("'scope_2' is active: ${scope_2.isActive}")

//    println("\n----------------------- #5 ---------------------")
//    // #5
//    // Use 'throw IllegalArgumentException' inside parent coroutine to stop the child coroutine.
//    val scope_3 = CoroutineScope(Dispatchers.IO)
//    val job_5 = scope_3.launch {
//        launch {
//            delay(300)
//            println("'job_5' child coroutine started.")
//        }
//        println("'job_5' is started.")
//        throw error("throw IllegalStateException")
//    }
//    job_5.invokeOnCompletion {
//        println("'job_5' is completed. $it")
//    }
//    job_5.join()

//    println("\n----------------------- #6 ---------------------")
//    // #6
//    // Use 'CoroutineExceptionHandler' to handle exception thrown inside the coroutine.
//    val exceptionHandler_1 = CoroutineExceptionHandler { coroutineContext, throwable ->
//        println("$coroutineContext | $throwable")
//    }
//    val scope_4 = CoroutineScope(Dispatchers.IO + exceptionHandler_1)
//    val job_6 = scope_4.launch {
//        launch {
//            delay(300)
//            println("'job_6' child coroutine started.")
//        }
//        println("'job_6' is started.")
//        throw error("throws IllegalStateException")
//    }
//    job_6.invokeOnCompletion {
//        println("'job_6' is completed. $it")
//    }

//    println("\n----------------------- #7 ---------------------")
//    // #7
//    // Use 'CoroutineScope' to create a scope of coroutines,
//    // passing explicitly 'SupervisorJob' to stop only the child coroutine when exception is thrown.
//    val exceptionHandler_2 = CoroutineExceptionHandler { coroutineContext, throwable ->
//        println("$coroutineContext | $throwable")
//    }
//    val scope_5 = CoroutineScope(Dispatchers.IO + SupervisorJob() + exceptionHandler_2)
//    val job_7 = scope_5.launch {
//        println("'job_7' is started.")
//        delay(100)
//        println("'job_7' is finished.")
//    }
//    job_7.invokeOnCompletion {
//        println("'job_7' completed. $it")
//        println("'scope_5' is active: ${scope_5.isActive}")
//    }
//    val job_8 = scope_5.launch {
//        println("'job_8' is started.")
//        throw error("throw IllegalStateException")
//        delay(100)
//        println("'job_8' is finished.")
//    }
//    job_8.invokeOnCompletion {
//        println("'job_8' completed. $it")
//        println("'scope_5' is active: ${scope_5.isActive}")
//    }

    println("\n----------------------- #8 ---------------------")
    // #8
    // Use 'supervisorScope' to create a scope of coroutines,
    // without cascade stop of coroutines if error appear in one child coroutine.
    // By default, 'SupervisorJob' will be used.
    supervisorScope {
        launch {
            println("'job_9' is started.")
            delay(100)
            println("'job_9' is finished.")
        }.invokeOnCompletion {
            println("'job_9' completed. $it")
            println("'supervisorScope' is active: ${coroutineContext.isActive}")
        }
        launch {
            println("'job_10' is started.")
            throw error("throw IllegalStateException")
            delay(100)
            println("'job_10' is finished.")
        }.invokeOnCompletion {
            println("'job_10' completed. $it")
            println("'supervisorScope' is active: ${coroutineContext.isActive}")
        }
    }
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
}

suspend fun loadRemote() = withContext(Dispatchers.IO) {
    val secondDispatcher = coroutineContext[ContinuationInterceptor]!!
    println("Second coroutine dispatcher: $secondDispatcher")
    println("Perform long task...")
}
