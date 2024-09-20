package syntax.functions.function_type.extension_func.example_2

fun main(args: Array<String>) {
    val sub = Submarine()
    sub.fire()
    sub.submerge()
    sub.submerge(10)
}

class Submarine {
    fun fire(): Unit {
        println("\nFiring torpedoes")
    }

    fun submerge(): Unit {
        println("\nSubmerging")
    }
}

// The 'extension' function will not be called because
// its signature matches to the member function of the
// 'Submarine' class.
fun Submarine.fire(): Unit {
    println("\nFire on board!")
}

// The 'extension' function will be called,
fun Submarine.submerge(depth: Int): Unit {
    println("\nSubmerging to a depth of $depth fathoms")
}
