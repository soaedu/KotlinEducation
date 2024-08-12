// The 'package' keyword is used to give a fully qualified name.
package syntax.package_import.example_1

// The 'import' keyword is used to enable a top-level method from the 'test' package.
import syntax.package_import.example_1.test.topLevelFunction

// The 'import' keyword is used to enable an interface from the 'test' package.
import syntax.package_import.example_1.test.FooInterface

// The 'import' keyword is used to enable a class from the 'test' package.
import syntax.package_import.example_1.test.FooClass

// The 'import' keyword is used to enable an object from the 'test' package.
import syntax.package_import.example_1.test.FooObject

fun main() {
    // Using top-level function from the 'test' package
    println(topLevelFunction())

    // Using interface from the 'test' package
    val fooObject = object : FooInterface {
        override fun interfaceResult() {
            println("Interface..")
        }
    }
    fooObject.interfaceResult()

    // Using class from the 'test' package
    FooClass().also {
        println(it.classResult())
    }

    // Using object from the 'test' package
    println(FooObject.objectResult)
}