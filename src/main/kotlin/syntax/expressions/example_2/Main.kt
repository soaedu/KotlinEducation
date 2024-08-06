package syntax.expressions.example_2

fun main() {
    // #1
    // Can't do this, because 'for' is a statement:
    // val f = for(i in 1..10) {}
    // Compiler error message:
    //  'for' is not an expression, and only expressions are allowed here

    // #2
    // Every function call is an 'expression'.
    // Even if the function returns 'Unit' and is called only for its side effects,
    // the result can still be assigned.
    println()
    println(unitFun())
    val u1: Unit = println(42)
    println(u1)
    val u2 = println(0) // Type inference
    println(u2)

    // #3
    // 'if' creates an expression, so we can assign its result.
    val result1 = if (11 > 42) 9 else 5
    val result2 = if (1 < 2) {
        val a = 11
        a + 42
    } else 42
    println()
    val result3 = if ('x' < 'y')  println("x < y") else println("x > y")
    println(result1)
    println(result2)
    println(result3)

    // #4
    // The increment/decrement operators are also expressions, even if they look like a statement.
    println()
    var i = 10
    println(i++)
    println(i)
    var j = 20
    println(++j)
    println(j)
    var k = 20
    println(k--)
    println(k)
    var l = 40
    println(--l)
    println(l)
}

// #2
fun unitFun() = Unit