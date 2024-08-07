package syntax.properties.regular.example_5

fun main() {
    val cage = Cage(2)
    // cage.maxCapacity                // Impossible

    println(
        "Check cage capacity:" +
        "\n\thow many hamsters can put inside: ${cage.capacity()}" +
        "\n\tis full: ${cage.full()}"
    )

    println(
        "\nput two hamsters.."
    )
    val putAliceResult = cage.put(Hamster("Alice"))
    val putBobResult = cage.put(Hamster("Bob"))
    println(
        "\tput 'Alice' result: \t$putAliceResult" +
        "\n\tput 'Bob' result: \t\t$putBobResult"
    )

    println(
        "\nCheck cage capacity:" +
        "\n\thow many hamsters can put inside: ${cage.capacity()}" +
        "\n\tis full: \t\t${cage.full()}"
    )

    println(
        "\nput one more hamster.."
    )
    val putCharlieResult = cage.put(Hamster("Charlie"))
    println("\tput 'Charlie' result: $putCharlieResult")

    println(
        "\nGet one hamster out of the cage.."
    )
    val hamsterTook = cage.take()
    val tookText = if (hamsterTook != null)
        "${hamsterTook.name} is took out"
    else
        "nobody was took..cage is empty"

    println("\t$tookText")
}

class Hamster(val name: String)

// The property is defined as 'private' and can't be accessed out of the class.
class Cage(private val maxCapacity: Int) {
    // The property is defined as 'private' and can't be accessed out of the class.
    private val hamsters = mutableListOf<Hamster>()

    // The property is defined without backing field, its value is calculated 'on the fly'.
    /*val capacity: Int
        get() = maxCapacity - hamsters.size*/
    // The property is similar to function without parameters and can be defined as such
    fun capacity(): Int = maxCapacity - hamsters.size

    // The property is defined without backing field, its value is calculated 'on the fly'.
    /*val full: Boolean
        get() = hamsters.size == maxCapacity*/
    // The property is similar to function without parameters and can be defined as such
    fun full(): Boolean = hamsters.size == maxCapacity

    fun put(hamster: Hamster): Boolean = if (full())
        false
    else {
        hamsters += hamster
        true
    }

    fun take(): Hamster? = if (hamsters.size > 0)
        hamsters.removeAt(0)
    else
        null
}
