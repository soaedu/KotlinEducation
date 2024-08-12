package syntax.package_import.example_1.test

fun topLevelFunction() = "Top-level function.."

interface FooInterface {
    fun interfaceResult()
}

class FooClass {
    fun classResult(): String = "Class.."
}

object FooObject {
    val objectResult = "Object.."
}

