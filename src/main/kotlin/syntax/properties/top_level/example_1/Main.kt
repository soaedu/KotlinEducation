package syntax.properties.top_level.example_1

fun main() {
    repeat(4) { performOperation() }
    reportOperationCount()
}

// #1
// The immutable property is defined as 'top-level' (outside any class).
val rate = 17.85

// #2
// The mutable property is defined as 'top-level' (outside any class).
var opCount = 0

fun performOperation() {
    opCount++
}

fun reportOperationCount() {
    println("Operation performed $opCount times")
}

