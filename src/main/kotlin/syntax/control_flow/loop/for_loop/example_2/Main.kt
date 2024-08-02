package syntax.control_flow.loop.for_loop.example_2

fun main() {

    // #1
    // The 'for' loop is used to get next values from the list ans print it.
    var step = 0
    val values = listOf("A", "B", "C")
    for (v in values) {
        println("${++step}: $v")
    }

    println()
    // #2
    // The 'for' loop is used to print values from the range of integers
    for (i in 1..3) {
        println("Hey $i!")
    }

    println()
    // #3
    // The 'for' loop is used to print values from two int ranges defined differently
    val range1 = 1..10
    val range2 = 0 until 10
    println("Range '1..10': $range1")
    println("Range '0 until 10 ': $range2")

    println()
    // #4
    // The 'for' loop is used to sum the numbers from 10 to 100.
    var sum = 0
    for (n in 10..100) {
        sum += n
    }
    println("Sum of numbers in range from 10 to 100 is: $sum")

    println()
    // #5
    // The 'for' loop is used to iterate over a range in direct order.
    val range_1 = 1..5
    showRange(
        "Iterate over a range '1..5' in direct order: ",
        range_1
    )

    val range_2 = 0 until 5
    showRange(
        "Iterate over a range '0 until 5' in direct order: ",
        range_2
    )

    // The 'for' loop is used to iterate over a range in reverse order.
    val range_3 = 5 downTo 1
    showRange(
        "Iterate over a range '5 downTo 1' in reverse order: ",
        range_3
    )

    // The 'for' loop is used to iterate over a range in direct/reverse order using a step value.
    val range_4 = 0..9 step 2
    showRange(
        "Iterate over a range '0..9 step 2' in direct order using a step value: ",
        range_4
    )

    val range_5 = 0 until 10 step 3
    showRange(
        "Iterate over a range '0 until 10 step 3' in direct order using a step value: ",
        range_5
    )

    val range_6 = 9 downTo 2 step 3
    showRange(
        "Iterate over a range '9 downTo 2 step 3' in reverse order using a step value: ",
        range_6
    )

    // #6
    // The 'for' loop iterates from 'a' to 'z' - range of characters.
    for (c in 'a'..'z') {
        print(c)
    }
}

private fun showRange(message: String, r: IntProgression) {
    println(message)
    for (i in r) {
        print("$i ")
    }
    print("\t\t $r")
    println("\n")
}

