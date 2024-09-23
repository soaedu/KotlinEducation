package syntax.functions.operation.example_2

import java.io.ByteArrayOutputStream
import java.io.OutputStream

/**
 * Operation 'overriding' helps us to redefine one of the methods inherited from one
 * of the parent classes or interfaces in our new class.
 */
fun main() {
    // #1
    val os = ByteArrayOutputStream()
    val pngImage = PNGImage()
    pngImage.save(os)

    println()

    // #2
    with(Person("Tom")) {
        display()       		// Name: Tom
    }

    with(Employee("Bob", "JetBrains")) {
        println()
        display()       		// Name: Bob  Company: JetBrains
    }

    with(Manager("Alex", "JetBrains")) {
        println()
        display()
    }
}

// #1
open class Image {
    open fun save(output: OutputStream) {
        println("Some logic to save an image")
    }
}
interface VendorImage {
    fun save(output: OutputStream) {
        println("Vendor saving an image")
    }
}
class PNGImage: Image(), VendorImage {
    override fun save(output: OutputStream) {
        // Referencing the parent implementation is done via 'super<PARENT>'
        super<VendorImage>.save(output)
        super<Image>.save(output)
    }
}

// #2
open class Person(val name: String) {
    open fun display() = print("Name: $name")

}
open class Employee(name: String, val company: String): Person(name) {
    override fun display() {
        // Call method in the class 'Person'.
        super.display()

        print(", Company: $company")
    }

    // We can deny further overriding of the function in derived classes.
    // final override fun display() = println("Name: $name, Company: $company")
}

class Manager(name: String, company: String): Employee(name, company) {
    // Use 'override' to redefine function that presents
    // in 'Person' class with 'open' keyword.
    override fun display() {
        print("Name: $name, Company: $company, Position: Manager")
    }

    // If method has 'final override' in the 'Employee' class
    // we can't override it anymore.
    /*override fun display() {
        println("Name: $name, Company: $company, Position: Manager")
    }*/
}
