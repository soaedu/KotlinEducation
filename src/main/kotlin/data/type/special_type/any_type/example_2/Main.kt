package data.type.special_type.any_type.example_2

import data.helpers.printItems

fun main() {
    with(Storage()) {
        printItems(
            "Show storage products",
                products
            )
    }
}

class Storage {
    // Use 'Any' type to group classes of different types in one list.
    val products = listOf<Any>(
        Animal("Lion", 150.87),
        Fruit("Feijoa", 0.20, "Argentina"),
        Table("Royal Lake", 34.15, "Green"),
    )
}

class Animal(
    val name: String,
    val weight: Double
) {
    override fun toString(): String {
        return "Animal(name='$name', weight=$weight)"
    }
}

class Table(
    val name: String,
    val weight: Double,
    val color: String
) {
    override fun toString(): String {
        return "Table(name='$name', weight=$weight, color='$color')"
    }
}

class Fruit(
    val name: String,
    val weight: Double,
    val country: String
) {
    override fun toString(): String {
        return "Fruit(name='$name', weight=$weight, country='$country')"
    }
}
