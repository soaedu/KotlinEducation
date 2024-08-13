package syntax.functions.function_type.higher_order_func.example_4

enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

// #1
// Define a function that has a return type: function.
fun calculateShippingCost(
    delivery: Delivery
): (Order) -> Double {
    return when (delivery) {
        Delivery.EXPEDITED -> { order -> 6 + (2.1 * order.itemCount)}
        else -> { order -> 1.2 * order.itemCount }
    }
}