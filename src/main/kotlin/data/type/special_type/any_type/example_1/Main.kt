package data.type.special_type.any_type.example_1

import data.helpers.printItems

fun main() {
    with(Storage()) {
        addProduct(
            "Gold",
            "0.15"
        )
        addProduct(
            "Diamond",
            155
        )
        addProduct(
            "Aluminium",
            ""
        )

        printItems("Show all products added to storage", products)
    }
}

class Storage {
    val products = mutableListOf<Product>()

    class Product(
        val name: String,
        val weight: Double
    ) {
        override fun toString(): String {
            return "Product(name='$name', weight=$weight)"
        }
    }

    // Use 'Any' type to get in 'weight' multiply types that inherit it.
    fun addProduct(name: String, weight: Any) {
        val productWeight = when (weight) {
            is String -> if (weight.isNotEmpty()) weight.toDouble() else 0.0
            is Int -> weight.toDouble()
            else -> 0.0
        }
        products.add(Product(name, productWeight))
    }
}
