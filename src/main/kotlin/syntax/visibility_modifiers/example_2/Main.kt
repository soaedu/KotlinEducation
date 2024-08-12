package syntax.visibility_modifiers.example_2

fun main() {
    // Instance of the 'private' class can be created only inside the current file.
    val privateClass = PrivateExample()
    // 'private' property and method are not available outside the 'private' class.
    /*println(
        "private class A info:" +
        "\n\tvariable i: ${privateClass.i}" +
        "\n\tmethod doSomething: ${privateClass.doSomething()}"
    )*/


    val protectedExampleA = ProtectedExampleA()
    // 'protected' property is not available outside the class or its derived class.
    /*println(
        "protected class A info:" +
        "\n\tvariable i: ${protectedExampleA.i}"
    )*/
    val protectedExampleB = ProtectedExampleB()
    println(
        "protected class B info:" +
        "\n\tvariable i: ${protectedExampleB.getValue()}"
    )

    // Instance of the 'internal' class can be created only inside the current module.
    val internalExample = InternalExample()
    println(
        "internal class info:" +
        "\n\tvariable i: ${internalExample.i}" +
        "\n\tmethod doSomething: ${internalExample.doSomething()}"
    )

    // Instance of the 'public' class can be created everywhere.
    val publicExample = PublicExample()
    println(
        "public class info:" +
        "\n\tvariable i: ${internalExample.i}" +
        "\n\tmethod doSomething: ${internalExample.doSomething()}"
    )
}

// private
private class PrivateExample {
    private val i = 1
    private fun doSomething() {
    }
}

// protected
open class ProtectedExampleA() {
    protected val i = 1
}
class ProtectedExampleB : ProtectedExampleA() {
    fun getValue() : Int {
        return i
    }
}

// internal
class InternalExample {
    internal val i = 1
    internal fun doSomething() { }
}

// public
class PublicExample {
    val i = 1
    fun doSomething() { }
}