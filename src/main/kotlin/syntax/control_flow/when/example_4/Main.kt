package syntax.control_flow.`when`.example_4

fun main() {
    whenWithoutArgs(3, 5)
    whenWithoutArgs(30, 5)
    whenWithoutArgs(30, 30)
}

fun whenWithoutArgs(x: Int, y: Int) {
    when {
        x < y -> println("x is less than y")
        x > y -> println("x is greater than y")
        else -> println("x must equal y")
    }
}