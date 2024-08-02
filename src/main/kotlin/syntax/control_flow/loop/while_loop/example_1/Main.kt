package syntax.control_flow.loop.while_loop.example_1

fun main() {
    // #1
    // The 'while' loop is used to print a '.' until condition() function returns 'true'.
    var acc = 0
    while (condition(acc)) {
        print(".")
        acc += 10
    }
    println("\nDot is printed ${acc/10} times.")

    // #2
    // The 'while' loop is used to perform operation until temp becomes equal to 0.
    var sum = 0
    var temp = 100

    while (temp != 0) {
        sum += temp     // sum = sum + temp;
        --temp
    }
    println("\nSum of values from 0 to 100 is: $sum")
}

fun condition(i: Int) = i < 100