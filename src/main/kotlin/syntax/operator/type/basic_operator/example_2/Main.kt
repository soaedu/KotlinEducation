package syntax.operator.type.basic_operator.example_2

fun main() {
    println(
        "Check '5' enter in range '1..10' (python approach): ${5 in 1..10}"
    )

    println("\nPrint all items from range '1..10': ")
    for (item in 1..10) {
        println("\titem: $item ")
    }

    println("\nPrint all items from range '1..10' except the last (use 'until'): ")
    for (item in 1 until 10) {
        println("\t$item")
    }

    println("\nPrint all items from range '10..1' (use 'downTo'): ")
    for (item in 10 downTo 1) {
        println("\titem: $item ")
    }

    // Step
    println("\nPrint all items from range '1..10' with fixed step (use 'step'): ")
    for (item in 1..10 step 2) {
        println("\titem: $item ")
    }
}
