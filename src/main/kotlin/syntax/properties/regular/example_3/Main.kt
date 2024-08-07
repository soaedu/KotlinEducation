package syntax.properties.regular.example_3

fun main() {
    val base = Base()
    println("\nClass \"Base\" property value: ${base.property1}")

    val derived1 = Derived1()
    println("\nClass \"Derived1\" property value: ${derived1.property1}")

    val derived2 = Derived2("Derived2::value")
    println("\nClass \"Derived2\" property value: ${derived2.property1}")
}

// Keyword 'open' should be specified in class declaration to have ability to inherit this class.
open class Base {
    // Keyword 'open' should be specified in property declaration to have ability to override it.
    open val property1: String
        get() = "Base::value"
}

class Derived1 : Base() {
    // The property of the base class is overriden in the class body
    override val property1: String
        get() = "Derived1::value"
}

// The property of the base class is overriden in the 'primary constructor'
class Derived2(override val property1: String) : Base() {}
