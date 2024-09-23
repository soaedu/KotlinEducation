package syntax.functions.parameter.example_2

import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode

fun main() {
    // #1
    val dividend = 20.00.toBigDecimal()
    val divisor = BigDecimal(2.34)

    // Convenient call(s) considering parameters with default values.
    val result_1 = divide(
        dividend,
        divisor
    )
    val result_2 = divide(
        dividend,
        divisor,
        2
    )
    val result_3 = divide(
        dividend,
        divisor,
        8,
        RoundingMode.HALF_DOWN
    )

    // It is not allowed to call a method omitting one or more parameters with default
    // values in the middle.
    // divide(BigDecimal(12.34), RoundingMode.HALF_DOWN)   // error: type mismatch

    // We can make the same call using 'named parameters' and 'default parameters':
    val result_4 = divide(
        dividend,
        divisor,
        roundingMode = RoundingMode.HALF_DOWN
    )

    println(
        "Show calculation result for:" +
        "\n\tresult_1: $result_1" +
        "\n\tresult_2: $result_2" +
        "\n\tresult_3: $result_3" +
        "\n\tresult_4: $result_4"
    )

    // #2
    val student_1 = Student_1("James Brown")
    val student_2 = Student_1("John Smith", false)
    val student_3 = Student_1("Mark Green", true, 35)
    val student_4 = Student_1("Eva Brown", false)

    println(
        "\nShow info about:" +
        "\n\tstudent #1: $student_1" +
        "\n\tstudent #2: $student_2" +
        "\n\tstudent #3: $student_3" +
        "\n\tstudent #4: $student_4"
    )
}

// #1
/**
 * However, sometimes the number of parameters means that we end up with many overloaded variations of the same
 * function, resulting in needless boilerplate. For example, the Java standard library "BigDecimal" has the following
 * functions:
 *      public BigDecimal divide(BigDecimal divisor)
 *      public BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode)
 *      public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode)
 *
 * In Kotlin, a function can define one or more of its parameters to have default values, which are used if the
 * arguments are not specified. This allows a single function to be defined for several use cases, thereby avoiding
 * the need for multiple overloaded variants.
 * Here is the "divide()" function again, but this time, by using default parameters, we can reduce the definition
 * to a single function:
 */
fun divide(
    dividend: BigDecimal,
    divisor: BigDecimal,
    scale: Int = 0,
    roundingMode: RoundingMode = RoundingMode.UNNECESSARY
): BigDecimal {
    val bigInteger: BigInteger = (dividend / divisor).toBigInteger()

    return BigDecimal(bigInteger).apply {
        setScale(scale, roundingMode)
    }
}

// #2
// Use multiple constructors (with passing default values)
class Student_1(val name: String, val registered: Boolean, val credits: Int) {
    constructor(name: String): this(name, false, 0)
    constructor(name: String, registered: Boolean): this(name, registered, 0)

    override fun toString(): String {
        return "Student_1(name='$name', registered=$registered, credits=$credits)"
    }
}

// Use one constructor with named parameters with default values instead of multiple constructors
class Student2(val name: String, val registered: Boolean = false, credits: Int = 0) {
    override fun toString(): String {
        return "Student2(name='$name', registered=$registered)"
    }
}
