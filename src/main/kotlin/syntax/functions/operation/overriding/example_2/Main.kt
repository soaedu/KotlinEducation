package syntax.functions.operation.overriding.example_2

/**
 * Operation 'overriding' helps us to redefine one of the methods inherited from one
 * of the parent classes or interfaces in our new class.
 */
fun main() {
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
