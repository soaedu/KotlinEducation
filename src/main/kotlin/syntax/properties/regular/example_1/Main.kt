package syntax.properties.regular.example_1

fun main() {
    // #1
    val cup_1 = Cup()
    cup_1.percentFull = 50
    val cup_2 = Cup()
    cup_2.percentFull = 100
    println("Percentage value for:" +
            // refer to property 'percentFull' with '.' notation
            "\n\tcup #1: ${cup_1.percentFull}" +
            "\n\tcup #2: ${cup_2.percentFull}"
    )

    // #2
    println("\nPercentage value for cup #1: ${cup_1.percentFull}")

    print("\tadd 50 to cup #1..and show its value: ")
    cup_1.add(50)
    println(cup_1.percentFull)

    print("\tadd 70 to cup #1..and show its value: ")
    cup_1.add(70)
    println(cup_1.percentFull)
}

class Cup {
    // #1
    // The 'property' is defined to keep a state (getter/setter will be generated automatically)
    var percentFull = 0

    // 2
    val max = 100
    fun add(increase: Int): Int {
        // Member function refer to the class property not using '.' notation
        percentFull += increase

        if (percentFull > max)
            percentFull = max

        return percentFull
    }
}