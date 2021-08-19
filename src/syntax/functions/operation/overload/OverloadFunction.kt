package syntax.functions.operation.overload

fun main() {
    println("1. ${printString("test")}")
    println("2. ${printString("test", 55)}")
    println("3. ${printString("test", toUpperCase = true)}")
    println("4. ${printString("test", number = 101, toUpperCase = true)}")
}

/**
 * From Kotlin Koans (overloaded methods written in Java):
public String foo(String name, int number, boolean toUpperCase) {
    return (toUpperCase ? name.toUpperCase() : name) + number;
}
public String foo(String name, int number) {
    return foo(name, number, false);
}
public String foo(String name, boolean toUpperCase) {
    return foo(name, 42, toUpperCase);
}
public String foo(String name) {
    return foo(name, 42)
}
*/

fun printString(name: String, number: Int = 42, toUpperCase: Boolean = false): String {
    return (if (toUpperCase) name.toUpperCase() else name) + number
}