package syntax.functions.function_type.extension_func.example_5


fun main() {
    val parent: Parent = Child()

    // When a compiler looks for the appropriate function he uses
    // only the receivers expression type, not the actual stored value.
    // That's why the:
    //      fun Parent.foo() = "parent"
    // function will be called.
    println(parent.foo())
}

open class Parent
class Child: Parent()

// Since 'extension' functions are static functions (on the compile time)
// 'overriding' doesn't work for it.
// When compiler finds the 'extension' function he transforms it to a static function.

// This function will be compiled into:
//      public static String foo(Parent parent) { return "parent"; }
fun Parent.foo() = "parent"

// This function will be compiled into:
//      public static String foo(Child child) { return "child"; }
fun Child.foo() = "child"