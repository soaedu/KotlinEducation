package reflection.example2


/**
 * КCallable - это суперинтерфейс для функций и свойств. Он объявляет метод call, с помощью которого можно вызвать
 * соответствующую функцию или метод чтения свойства.
 *   interface KCallable<out R> {
 *     fun call(vararg args: Any?): R
 *     ...
 *   }
 * Аргументы для вызываемой функции передаются в списке vararg.
 *
 * Если у вас есть KFunction определенного типа с известными типами параметров и возвращаемого значения,
 * предпочтительнее использовать метод "invoke". Метод call более универсальный инструмент, работающий со всеми типами
 * функций, но он не поддерживает безопасность типов.
 */
fun main() {
    // Используем метод call для вызова функции с использованием механизма рефлексии
    val kFunction1 = ::foo
    print("1. ")
    kFunction1.call(42)
    // kFunction1.call()                // Ошибка во время выполнения:
                                        //   Callable expects 1 arguments, but 0 were provided.

    val kFunction2 = ::sum
    // val kFunction2: KFunction2<Int, Int, Int> = ::sum
    print("2.sum result: ${kFunction2.invoke(1, 2) + kFunction2(3, 4)}")
    //kFunction2.invoke()               // Ошибка на этапе компиляции:
                                        //   Kotlin: No value passed for parameter 'x'
}

fun foo(x: Int) = println(x)
fun sum(x: Int, y: Int) = x + y