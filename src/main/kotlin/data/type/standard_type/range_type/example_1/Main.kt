package data.type.standard_type.range_type.example_1

fun main() {
    // #1
    val rangeOfNumber_1 = IntRange(0, 10)

    // #2
    val rangeOfNumber_2 = 0..10

    // #3
    val rangeOfNumber_3 = 0.rangeTo(10)

    // #4
    val rangeOfNumber_4 = 10.downTo(0).reversed()

    println(
        "Show range created by:" +
        "\n\t'IntRange': $rangeOfNumber_1" +
        "\n\t'..': $rangeOfNumber_2" +
        "\n\t'rangeTo': $rangeOfNumber_3" +
        "\n\t'downTo' + 'reversed': $rangeOfNumber_4"
    )
}
