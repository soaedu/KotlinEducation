package data.type.standard_type.collection_type.type.sequence_type.example_1

import data.helpers.printItems
import java.io.File

fun main() {
    // #1
    // Use 'emptySequence' to create an empty sequence.
    val emptySequence = emptySequence<Int>()

    // #2
    // Use 'sequenceOf' to create a sequence.
    val sequenceOfNumber_1 = sequenceOf("four", "three", "two", "one")

    // #3
    // Use 'asSequence' to create a sequence.
    val listOfNumber = listOf("one", "two", "three", "four")
    val sequenceOfNumber_2 = listOfNumber.asSequence()

    // #4
    // Use 'generateSequence' to create a sequence.
    var nextItem = 0
    val sequenceOfNumber_3 = generateSequence {
        nextItem += 1
        nextItem
    }.takeWhile {
        it < 10
    }
    // Use 'generateSequence' with a seed to create a sequence.
    val sequenceOfOddNumber_1 = generateSequence(1) { it + 2 }
    // The sequence is infinite so error will appear: OutOfMemoryError
    // val result_1 = sequenceOfOddNumber.count()
    val result_2 = sequenceOfOddNumber_1.take(5).toList()
    // Provide 'null' after the last element we need and generation will stop.
    val result_3 = generateSequence(1) {
        if (it < 8) it + 2 else null
    }
    // Use 'generateSequence' using a 'parent sequence' to create a sequence with hidden file.
    val file = File("/some_file.kt")
    val result_4 = generateSequence(file) { it.parentFile }.find { it.isHidden }

    // #5
    // Use 'sequence' to create a sequence.
    val sequenceOfOddNumber_2 = sequence {
        yield(1)
        yieldAll(listOf(3, 5))
        yieldAll(generateSequence(7) { it + 2})
    }
    val result_5 = sequenceOfOddNumber_2.take(5).toList()
    // Use 'sequence' with 'while' loop to generate a sequence.
    val sequenceOfOddNumber_3 = sequence {
        var x = 1
        while (true) {
            yield(x)
            x += 2
        }
    }
    val result_6 = sequenceOfOddNumber_3.take(7).toList()

    printItems(
        "Show info about empty sequence created with 'emptySequence':" +
        "\n\tclass name (canonicalName): ${emptySequence.javaClass.canonicalName}" +
        "\n\tclass name (name): ${emptySequence.javaClass.name}",
        emptySequence
    )

    printItems(
        "Show info about sequence created with 'sequenceOf':" +
        "\n\tclass name (canonicalName): ${sequenceOfNumber_1.javaClass.canonicalName}" +
        "\n\tclass name (name): ${sequenceOfNumber_1.javaClass.name}",
        sequenceOfNumber_1
    )

    printItems(
        "Show info about sequence created from list with 'asSequence':" +
        "\n\tclass name (canonicalName): ${sequenceOfNumber_2.javaClass.canonicalName}" +
        "\n\tclass name (name): ${sequenceOfNumber_2.javaClass.name}",
        sequenceOfNumber_2
    )

    printItems(
        "Show info about sequence created with 'generateSequence':" +
        "\n\tclass name (canonicalName): ${sequenceOfNumber_3.javaClass.canonicalName}" +
        "\n\tclass name (name): ${sequenceOfNumber_3.javaClass.name}",
        sequenceOfNumber_3
    )
    printItems(
        "Show info about sequence created with 'generateSequence' and seed specified:" +
        "\n\tclass name (canonicalName): ${sequenceOfOddNumber_1.javaClass.canonicalName}" +
        "\n\tclass name (name): ${sequenceOfOddNumber_1.javaClass.name}",
        result_2
    )
    printItems(
        "Show info about sequence created with 'generateSequence' and seed specified:" +
        "\n\tclass name (canonicalName): ${sequenceOfOddNumber_1.javaClass.canonicalName}" +
        "\n\tclass name (name): ${sequenceOfOddNumber_1.javaClass.name}",
        result_3
    )
    println(
        "Show result of sequence create from 'parent sequence': $result_4"
    )

    printItems(
        "Show info about sequence created with 'sequence':" +
        "\n\tclass name (canonicalName): ${sequenceOfOddNumber_2.javaClass.canonicalName}" +
        "\n\tclass name (name): ${sequenceOfOddNumber_2.javaClass.name}",
        result_5
    )
    printItems(
        "Show info about sequence created with 'sequence':" +
        "\n\tclass name (canonicalName): ${sequenceOfOddNumber_2.javaClass.canonicalName}" +
        "\n\tclass name (name): ${sequenceOfOddNumber_3.javaClass.name}",
        result_6
    )
}
