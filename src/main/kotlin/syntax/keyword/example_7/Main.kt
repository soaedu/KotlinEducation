package syntax.keyword.example_7

fun main() {
    println("\nExample of of using \"break\", \"continue\"...")

    myLabel@ for(x in 1..10) { // applying the custom label
        if(x == 5) {
            println("I am inside if block with value: $x \n\thence it will close the operation")

            // The 'break' keyword is used to terminate the controller flow.
            break@myLabel // specifying the label
        } else {
            println("I am inside else block with value: $x")

            // The 'continue' keyword is used to continue the loop.
            continue@myLabel
        }
    }
}
