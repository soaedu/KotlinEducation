package syntax.control_flow.loop.do_while.example_2

fun main() {
    var sum: Int = 0
    var input: String

    // The 'do-while' block is used to calculate the sum of entered by user number in console.
    do {
        print("Enter an integer: ")
        input = readLine()!!
        sum += input.toInt()

    } while (input != "0")

    println("sum = $sum")
}