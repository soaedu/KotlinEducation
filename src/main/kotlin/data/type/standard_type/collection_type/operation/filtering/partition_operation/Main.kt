package data.type.standard_type.collection_type.operation.filtering.partition_operation

fun main() {
    // #1
    val listOfNumber_1 = listOf(1, 2, 3, 4, 5)
    val partitionResult_1 = splitList(listOfNumber_1)
    val partitionResult_2 = listOfNumber_1.partition { it %2 == 0 }
    val (evenValues, oddValues) = listOfNumber_1.partition { it %2 == 0 }
    println(
        "Show partitioning result applied to 'listOfNumber_1':" +
        "\n\t1. evenValues: ${partitionResult_1.first}, oddValues: ${partitionResult_1.second}" +
        "\n\t2. evenValues: ${partitionResult_2.first}, oddValues: ${partitionResult_2.second}" +
        "\n\t3. evenValues: $evenValues, oddValues: $oddValues"
    )

    // #2
    val targetValue = 42
    val listOfNumber_2 = listOf(42, 1984, 1, 0, -4, 23, 100, 6, 8)
    val (lessThanTargetValue, equalOrGreaterThanTargetValue) = listOfNumber_2.partition { it < targetValue }
    println(
        "Show partitioning result applied to 'listOfNumber_2':" +
        "\n\tlessThanTargetValue: $lessThanTargetValue, equalOrGreaterThanTargetValue: $equalOrGreaterThanTargetValue"
    )
}

// #1
fun splitList(sourceList: List<Int>): Pair<List<Int>, List<Int>> {
    val listWithEvenNumber = mutableListOf<Int>()
    val listWithOddNumber = mutableListOf<Int>()

    for (value in sourceList) {
        if (value % 2 == 0) listWithEvenNumber.add(value)
        else listWithOddNumber.add(value)
    }

    return Pair(
        listWithEvenNumber,
        listWithOddNumber
    )
}
