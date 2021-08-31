package syntax.functions.type.extension_func.example9

/**
 * Поскольку функции расширения являются статическими функция (на этапе компиляции), для них не работает
 * переопределение (override).
 * Когда компилятор встречает фунцию расширение он превращает ее в статическую функцию:
 *  public static String foo(Parent parent) { return "parent"; }
 *  public static String foo(Child child) { return "child"; }
 * Когда компилятор выбирает подходящую функцию, он использует только тип выражения получателя,
 * не фактическое сохраненное значение.
 */
fun main(args: Array<String>) {
    val parent: Parent = Child()
    println(parent.foo())
}

open class Parent
class Child: Parent()


fun Parent.foo() = "parent"     // В результате выполнения, будет выбрана эта функция.
fun Child.foo() = "child"