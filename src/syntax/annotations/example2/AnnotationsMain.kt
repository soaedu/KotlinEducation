package syntax.annotations.example2

fun main() {

}

/**
 * Exposes a Kotlin property as a field in Java
 *
 * If modifier is:
 *      "val" - no getter
 *      "var" - no getter/setter
 * will be generated by a compiler
 */
@JvmField
val prop = MyClass()

// The same as
// Java
// public static final MyClass prop = new MyClass();

class MyClass

/**
 * @JvmField creates property static if it's used at the top level or inside the object.
 */
object A {
    @JvmField
    val prop = MyClass()
}

/**
 * @JvmField creates regular field
 */
class B {
    @JvmField
    val prop = MyClass()
}