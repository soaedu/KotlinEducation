package syntax.operator.type.basic_operator.example_1

fun main() {
    val value_1 = 2
    val value_2 = 5
    val value_3 = false
    println(
        "Show result of using 'basic operators':" +
        "\n\toperation '$value_1+$value_2': ${value_1+value_2}, function '$value_1.plus($value_2)': ${value_1.plus(value_2)}" +
        "\n\toperation '$value_1-$value_2': ${value_1-value_2}, function '$value_1.minus($value_2)': ${value_1.minus(value_2)}" +
        "\n\toperation '$value_1*$value_2': ${value_1*value_2}, function '$value_1.times($value_2)': ${value_1.times(value_2)}" +
        "\n\toperation '$value_1/$value_2': ${value_1/value_2}, function '$value_1.div($value_2)': ${value_1.div(value_2)}" +
        // "\n\toperation '$value_1&$value_2': ${value_1&value_2}, function '$value_1.mod($value_2)': ${value_1.mod(value_2)}" +
        "\n\toperation '$value_1..$value_2': ${value_1..value_2}, function '$value_1.rangeTo($value_2)': ${value_1.rangeTo(value_2)}" +
        "\n\toperation '+$value_1': ${+value_1}, function '$value_1.unaryPlus()': ${value_1.unaryPlus()}" +
        "\n\toperation '-$value_1': ${-value_1}, function '$value_1.unaryMinus()': ${value_1.unaryMinus()}" +
        "\n\toperation '!$value_3': ${!value_3}, function '$value_3.not()': ${value_3.not()}"
    )
}
