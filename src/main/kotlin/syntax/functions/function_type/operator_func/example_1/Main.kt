package syntax.functions.function_type.operator_func.example_1

fun main() {
    var matrix_1 = Matrix(1, 2, 3, 4)
    val matrix_2 = Matrix(5, 6, 7, 8)

    // #1
    // Use direct call to operator function using '.'
    // val matrix_3 = matrix_1.plus(matrix_2)
    // Use operator '+' that is represented by 'operator function'
    val matrix_3 = matrix_1 + matrix_2

    // #2
    // Use direct call to operator function using '.'
    // val matrix_4 = matrix_1.minus(matrix_2)
    // Use operator '-' that is represented by 'operator function'
    val matrix_4 = matrix_1 - matrix_2

    // #3
    // Use direct call to operator function using '.'
    // val matrix_5 = matrix_1.times(matrix_2)
    // Use operator '*' that is represented by 'operator function'
    val matrix_5 = matrix_1 * matrix_2

    // #4
    // Use direct call to operator function using '.'
    // val matrix_6 = matrix_1.div(matrix_2)
    // Use operator '/' that is represented by 'operator function'
    val matrix_6 = matrix_1 / matrix_2

    // #5
    // Use direct call to operator function using '.'
    // val matrix_7 = matrix_1.rem(matrix_2)
    // Use operator '%' that is represented by 'operator function'
    val matrix_7 = matrix_1 % matrix_2

    // #6
    // Use direct call to operator function using '.'
    // val matrix_8 = matrix_1.rangeTo(matrix_2)
    // Use operator '..' that is represented by 'operator function'
    val matrix_8 = matrix_1..matrix_2

    // #7
    // Use direct call to operator function using '.'
    // val matrix_9 = matrix_1.unaryPlus()
    // Use operator 'unary +' that is represented by 'operator function'
    val matrix_9 = +matrix_1

    // #8
    // Use direct call to operator function using '.'
    // val matrix_10 = matrix_1.unaryMinus()
    // Use operator 'unary +' that is represented by 'operator function'
    val matrix_10 = -matrix_1

    // #9
    // Use direct call to operator function using '.'
    // val matrix_11 = matrix_1.not()
    // Use operator '!' that is represented by 'operator function'
    val matrix_11 = !matrix_1

    // #10
    // Use direct call to operator function using '.'
    // val matrix_12 = matrix_1.inc()
    // Use operator '++' that is represented by 'operator function'
    // val matrix_12 = matrix_1++
    val matrix_12 = ++matrix_1

    // #11
    // Use direct call to operator function using '.'
    // val matrix_13 = matrix_1.dec()
    // Use operator '--' that is represented by 'operator function'
    // val matrix_13 = matrix_1--
    val matrix_13 = --matrix_1

    println(
        "Show matrices and their sum:" +
        "\n\tsource matrix #1: $matrix_1" +
        "\n\tsource matrix #2: $matrix_2" +
        "\n\tresult matrix #3 (sum with '.' or '+'): $matrix_3" +
        "\n\tresult matrix #4 (minus with '.' or '-'): $matrix_4" +
        "\n\tresult matrix #5 (multiplication with '.' or '*'): $matrix_5" +
        "\n\tresult matrix #6 (division with '.' or '/'): $matrix_6" +
        "\n\tresult matrix #7 (modulo with '.' or '%'): $matrix_7" +
        "\n\tresult matrix #8 (range with '.' or '..'): $matrix_8" +
        "\n\tresult matrix #9 (unary plus with '.' or '+'): $matrix_9" +
        "\n\tresult matrix #10 (unary minus with '.' or '-'): $matrix_10" +
        "\n\tresult matrix #11 (not with '.' or '!'): $matrix_11" +
        "\n\tresult matrix #12 (inc with '.' or '++'): $matrix_12" +
        "\n\tresult matrix #13 (dec with '.' or '--'): $matrix_13"
    )
}

class Matrix(
    val a: Int,
    val b: Int,
    val c: Int,
    val d: Int,
) {
    // Define 'operator function'
    operator fun plus(matrix: Matrix): Matrix {
        return Matrix(
            a + matrix.a,
            b + matrix.b,
            c + matrix.c,
            d + matrix.d
        )
    }

    operator fun minus(matrix: Matrix): Matrix {
        return Matrix(
            a - matrix.a,
            b - matrix.b,
            c - matrix.c,
            d - matrix.d
        )
    }

    operator fun times(matrix: Matrix): Matrix {
        return Matrix(
            a * matrix.a,
            b * matrix.b,
            c * matrix.c,
            d * matrix.d
        )
    }

    operator fun div(matrix: Matrix): Matrix {
        return Matrix(
            a / matrix.a,
            b / matrix.b,
            c / matrix.c,
            d / matrix.d
        )
    }

    operator fun rem(matrix: Matrix): Matrix {
        return Matrix(
           a % matrix.a,
            b % matrix.b,
            c % matrix.c,
            d % matrix.d
        )
    }

    operator fun rangeTo(matrix: Matrix): Matrix {
        return Matrix(
            (a..matrix.a).random(),
            (b..matrix.b).random(),
            (c..matrix.c).random(),
            (d..matrix.d).random()
        )
    }

    operator fun unaryPlus(): Matrix {
        return Matrix(
            +a,
            +b,
            +c,
            +d
        )
    }

    operator fun unaryMinus(): Matrix {
        return Matrix(
            -a,
            -b,
            -c,
            -d
        )
    }

    operator fun not(): Matrix {
        return Matrix(
            if (!(a > 0)) 0 else 1,
            if (!(b > 0)) 0 else 1,
            if (!(c > 0)) 0 else 1,
            if (!(d > 0)) 0 else 1
        )
    }

    operator fun inc(): Matrix {
        var localA = a
        var localB = b
        var localC = c
        var localD = d
        return Matrix(
            localA++,
            ++localB,
            ++localC,
            localD++
        )
    }

    operator fun dec(): Matrix {
        var localA = a
        var localB = b
        var localC = c
        var localD = d
        return Matrix(
            --localA,
            localB--,
            --localC,
            localD--
        )
    }

    override fun toString(): String {
        return "Matrix(a=$a, b=$b, c=$c, d=$d)"
    }
}