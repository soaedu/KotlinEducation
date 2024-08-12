package syntax.visibility_modifiers.example_3

import java.lang.reflect.Modifier

fun main() {
    val derivedContainer = DerivedContainer()
    println("\nchild class DerivedContainer.fieldA: ${derivedContainer.fieldA}")
    derivedContainer.printFieldA()

    // will not compile
    // Error: Can not access "fieldA": It is protected in 'Container'
    /*val container: Container = derivedContainer
    println("fieldA:${container.fieldA}")*/

    println("\nPrint all inherited fields from the 'Container' class: ")
    derivedContainer.javaClass.superclass.getDeclaredFields().forEach { field->
        field.setAccessible(true)

        println("\tField:${field.name}, ${Modifier.toString(field.modifiers)}, Value=${field.get(derivedContainer)}")
    }

    println("\nPrint all declared fields in the 'Derived' class: ")
    derivedContainer.javaClass.getDeclaredFields().forEach { field->
        field.setAccessible(true)

        println("\tField:${field.name}, ${Modifier.toString(field.modifiers)}, Value=${field.get(derivedContainer)}")
    }
}

open class Container {
    protected open val fieldA: String = "\"Container\" class value"
}

class DerivedContainer : Container() {
    public override val fieldA: String = "\"DerivedContainer\" class value"

    // Call to 'fieldA' in the parent class using keyword 'super'
    fun printFieldA() = println("parent class Container.fieldA: ${super.fieldA}")
}