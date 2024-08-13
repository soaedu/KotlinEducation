package syntax.functions.function_type.higher_order_func.example_4

fun main() {
    // #1
    // Use function that has return type a function.
    val order = Order(3)
    val calculateCost = calculateShippingCost(
        Delivery.EXPEDITED
    )
    println(
        "\nPrint shipping cost:" +
        "\n\t${calculateCost(order)}"
    )

    // #2
    // Use function that has return type a predicate.
    val persons = listOf(
        Person("John", "Smith", "555-25-36"),
        Person("Alice", "Smith", null)
    )
    val contactListFilter = ContactListFilter().apply {
        // startsWith = "Joh"
        startsWith = "Al"
        withPhoneNumberOnly = true
    }

    println(
        "\nPrint contact list filter result:" +
        "\n\t${persons.filter(contactListFilter.getFilterPredicate())}"
    )
}
