package syntax.control_flow.`when`.example_1

fun main(args: Array<String>) {
    val x: Int = 5
    when (x) {
        // #1
        /*1 -> print("x = = 1")
        2 -> print("x = = 2")*/

        // #2
        1,2 -> print(" Value of x either 1,2")

        else -> {
            print("x is neither 1 nor 2")
        }
    }
}