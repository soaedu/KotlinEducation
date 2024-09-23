package syntax.functional_programming.operation.reference.example_1

/**
 * Operation 'reference' is used when we want to refer to an existing function and call it.
 */
fun main() {
    val example = Example()
    println(
        "Show result of:" +
        "\n\taddition (direct call): ${example.add(2, 3)}" +
        "\n\taddition (assigning call): ${example.doIt(example.operation)}" +
        "\n\taddition (passing function call): ${example.doAdd()}" +
        "\n\taddition (passing a returned function call): ${example.doIt(example.getOperation("addition"))}"
    )
}

class Example {
    fun add(a: Int, b: Int) = a + b
    fun mlt(a: Int, b: Int) = a * b

    // Assigning a function
    val operation = this::add

    fun doIt(operation: (Int, Int) -> Int): Int {
        return operation.invoke(2, 3)
    }

    // Passing a function
    fun doAdd() = doIt(this::add)
    fun doMlt() = doIt(this::mlt)

    // Returning a function
    fun getOperation(name: String) = when (name) {
        "addition" -> this::add
        "multiplication" -> this::mlt
        else -> { a, b -> 0}
    }
}
