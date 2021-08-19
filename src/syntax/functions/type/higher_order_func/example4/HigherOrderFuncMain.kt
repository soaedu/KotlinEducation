package syntax.functions.type.higher_order_func.example4

/**
 * Возврат функций из функций
 *
 * Чтобы объявить функцию, возвращающую другую функцию, нужно указать, что возвращаемое значение имеет тип функции.
 */
fun main() {
    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
    println("1. Shipping costs: ${calculator(Order(3))}")

    val contacts = listOf(
        Person( "Dmitry", "Jemerov", "123-4567"),
        Person("Svetlana", "Isakova", null)
    )
    val contactListFilters = ContactListFilters()
    with (contactListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }
    // Передача функции, полученной от getPredicate, в виде аргумента методу "filter"
    println("2. show contacts: ${contacts.filter(contactListFilters.getPredicate())}")
}

/**
 * Определение функции, возвращающей другую функцию
 */
enum class Delivery { STANDARD, EXPEDITED }
class Order(val itemCount: Int)
fun getShippingCostCalculator(
    delivery: Delivery): (Order) -> Double {            // Объявление функции, возвращающей другую функцию

    if (delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }   // Возврат лямбда-выражения из функции
    }

    return { order -> 1.2 * order.itemCount }           // Возврат лямбда-выражения из функции
}

/**
 * Использование функции, возвращающей другую функцию
 */
data class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?
)
class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    // Объявпение Функции, возвращающей другую функцию
    fun getPredicate(): (Person) -> Boolean {
        val startsWithPrefix = { p: Person ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }

        // Объявление функций высшего порядка
        if (!onlyWithPhoneNumber) {
            return startsWithPrefix                                 // Возврат переменной с типом функции
        }

        return { startsWithPrefix(it) && it.phoneNumber != null }   // Возврат лямбда-выражения из этой функции
    }
}
