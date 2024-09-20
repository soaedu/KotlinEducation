package syntax.functional_programming.operation.reference.example_3

fun main() {
    with(Example()) {
        // #1
        println("Show result (call top-level function): $sum")

        // #2
        println("Show result (call local function): ${calculateSum()}")

        // #3
        // Create a reference on the top-level function directly
        print("Call top-level function using reference directly -> ")
        run(::salute)
    }
}

fun add(a: Int, b: Int) = a + b

fun salute() = print("Hello!")

class Example {
    // #1
    // Use 'function reference' on a top-level function as 'unbound reference'.
    val operation = ::add
    var sum = operation(1, 2)

    // #2
    // Use local 'function reference' as 'unbound reference'.
    fun calculateSum(): Int {
        fun add(a: Int, b: Int) = a + b
        val operation = ::add

        return operation(10, 20).apply {
            sum = this
        }
    }
}