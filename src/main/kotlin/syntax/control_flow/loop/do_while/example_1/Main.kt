package syntax.control_flow.loop.do_while.example_1

fun main() {
    // #1
    // The 'do-while' loop is used to print values in range from
    // 0 to 60 with step = 10.
    var x = 0
    do {
        x += 10
        println("I'm inside the 'do' block with value: $x")
    } while (x <= 50)

    // #2
    // The 'do-while' loop is used to search the first element
    // in the list that contains letter 'e'.
    val sourceList = listOf("Algebra", "Biology", "Chemistry")
    var canSearch = true
    var result = ""
    var index = 0

    do {
        require(index < sourceList.size) { "Value 'index' has an invalid value!"}
        val listValue = sourceList[index]
        if (listValue.toLowerCase().contains("e")) {
            result = listValue
            canSearch = false
        }
        index++
    } while (canSearch)

    println("\nFound letter 'e' in: $result")
}
