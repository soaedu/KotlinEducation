package syntax.control_flow.loop.for_loop.example_1

fun main() {
    val items = listOf(1, 22, 83, 4)

    // #1 The 'for' loop is used to iterate throw a list and print all its items.
    // On each iteration we get an item of the list.
    println("\n#1 Integer list items:")
    for (i in items) println("item: $i")

    // #2 The 'for' loop is used to iterate throw a list and print all its items.
    // On each iteration we get index and value of the list item.
    println("\n#2 Integer list items (withIndex):")
    for ((index, value) in items.withIndex()) {
        println("item[$index]: $value")
    }

    // #3 The 'for' loop is used to iterate throw a list and print all its items.
    // On each iteration we get index and then use it to get value of the list item.
    println("\n#3 Integer list items (indices):")
    for (index in items.indices) {
        println("item[$index]: ${items[index]}")
    }

    // #4 The 'for' loop is used to iterate throw a list and print all its items.
    // On each iteration we get the index from the range of 0 .. last list item index.
    // Then we use that index to get value of the list item.
    println("\n#4 Integer list items (lastIndex):")
    for (index in 0..items.lastIndex) {
        println("item[$index]: ${items[index]}")
    }

    // #5 The 'for' loop is used to iterate throw a list and print all its items.
    // On each iteration we get the index from the range of 0 .. last list item index got from the list size.
    // Then we use that index to get value of the list item.
    println("\n#5 Integer list items (until):")
    for (index in 0 until items.size) {
        println("item[$index]: ${items[index]}")
    }

    // #6 The 'for' loop is used to iterate throw a string and print all its items.
    // On each iteration we get a char from the string.
    println("\n#6 String chars:")
    val string = "print my characters"
    for (char in string) {
        println(char)
    }

    // #7 The 'for' loop is used to iterate throw two ranges of int values.
    // On each iteration in the outer 'for' loop we use thw inner 'for' loop and use values from the both
    // 'for' loops to calculate and print a result.
    println("\n#7 Integer ranges items multiply result:")
    val oneToThree = 1..3
    for (k in oneToThree) {
        for (j in 1..2) {
            println(k * j)
        }
    }
}