package syntax.functions.type.higher_order_func.example2

/**
 *
 */
fun main() {
    println("1. ")
    twoAndThree { a, b -> a + b}
    twoAndThree { a, b -> a * b}

    println("2. ${"1a2b3c".filter { it in 'a'..'z' }}")
}

// Определение простой функции высшего порядка
fun twoAndThree(operation: (Int, Int) -> Int) {     // Объявленние параметра с типом функции
    val result = operation(2, 3)                    // Вызов параметра с типом функции
    println("Result of the operation is: $result")
}

/**
 * Определим свою реализацию функции filter из стандартной библиотеки.
 * Для простоты ограничимся поддержкой только типа String.
 *
 * Функция filter принимает предикат как параметр. Тип predicate - это функция, которая получает параметр из одного
 * символа и возвращает логический результат: true, если символ удовлетворяет требованиям предиката и может быть
 * включен в результирующую строку, и false в противном случае.
 */
fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()

    for (index in 0 until length) {
        val element = get(index)

        if (predicate(element)) // вызов функции, переданной как аргумент для параметра "predicate"
            sb.append(element)
    }

    return sb.toString()
}

