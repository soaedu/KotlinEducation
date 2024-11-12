package coroutines.example_5

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/**
 * Coroutine channels let us transmit flows of data.
 * For this purpose we can use interface 'Channel' and its methods:
 *      * abstract suspend fun close(cause: Throwable? = null): Boolean
 *      * abstract suspend fun receive(): E
 *      * abstract suspend fun send(element: E): Unit
 */
suspend fun main() {
    // #1
    // Use 'Channel' interface to create an anonymous class implementing this
    // interface and using it to send numbers in cycle and receive them out.
    coroutineScope {
        val channel = Channel<Int>()
        launch {
            for (i in 1..5) {
                // send data throw the channel
                channel.send(i)
            }
            // close channel
            channel.close()
        }

        // receive from the channel all recently sent data
        // even if close channel event is got
        repeat(5) {
            val number = channel.receive()
            println(number)
        }
        println("End")
    }

    println()

    // #2
    // Use 'ReceiveChannel' to send data from one coroutine to another
    coroutineScope {
        val users = getUsers()

        // get all data from the channel
        users.consumeEach { user -> println(user) }

        println("End")
    }
}

private fun CoroutineScope.getUsers(): ReceiveChannel<String> = produce {
   val users = listOf("Tom", "Bob", "Sam")
   for (user in users) {
       send(user)
   }
}
