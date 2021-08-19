package syntax.functions.type.higher_order_func.example3

/**
 *
 */
fun main() {
    val letters = listOf("Alpha", "Beta")

    // Используем функцию для преобразования данных в строку, по-умолчанию
    println("1. print string: ${ letters.joinToString() }")

    // Передается аргумент с лямбда-выражением
    println("2. print string: ${ letters.joinToString { it.toLowerCase() }}")

    // Использование синтаксиса именованных аргументов дпя передачи нескольких аргументов, вкпючая пямбда·выражение
    println("3. print string: ${letters.joinToString(
                separator = "! ",
                postfix = "! ",
                transform = { it.toUpperCase()}
            )}"
    )

    // Использование синтаксиса именованных аргументов дпя передачи нескольких аргументов, вкпючая пямбда·выражение,
    // которое равно null
    println("4. print string: ${letters.joinToString(
        separator = "! ",
        postfix = "! ",
        transform = null
    )}")
}

/**
 * joinToString с жестко зашитым преобразованием toString
 *
 * Это гибкая реализация, но она не позволяет контролировать один важный аспект: преобразование в строки отдельных
 * элементов коллекции.
 * Код использует вызов StringBuilder.append(o: Any? ), который всегда преобразует объекты в строки с помощью метода
 * toString().
 */
// #1
/*fun <T> Collection<T>.joinToString(separator: String = ", ", prefix: String = "", postfix: String = ""): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0 ) result.append(separator)

        // Преобразует объект в строку с использованием реализации toString по умопчанию
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}*/

/**
 * Объявление параметра с типом функции и значением по умолчанию
 */
// #2
/*fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: (T) -> String = { it.toString() }    // Объявление параметра с типом функции и пямбда-выражением
                                                    // в качеаве значения по-умолчанию
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)

        result.append(transform(element))           // Вызов функции, переданной в аргументе дnя параметра "transform"
    }

    result.append(postfix)
    return result.toString()
}*/

/**
 * Использование параметра с типом функции, способного принимать значение null
 *
 * fun foo(callback: (() -> Unit)?) {
 *     // ...
 *     if (callback != null) {
 *          callback()
 *     }
 * }
 *
 * Функцию, переданную в таком параметре, нельзя вызвать непосредственно: Kotlin откажется компилировать такой код,
 * потому что обнаружит возможность появления исключения, вызванного обращением к пустому указателю.
 * Одно из возможных решений - явно проверить на равенство значению null.
 *
 * Более короткое решение основано на том, что тип функции - это реализация интерфейса с методом invoke.
 * Обычный метод, каковым является invoke(), можно вызвать, использовав синтаксис безопасного вызова: callback?.invoke()
 * Вот как можно использовать этот приём в измененной версии joinToString().
 */
// #3
fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null      // Объявление параметра с типом функции, сnособноrо принимать значение null
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)

        val str = transform?.invoke(element)    // Использование специального синтаксиса дnя безопасного вызова функции
            ?: element.toString()               // Использование оператора «Эпвис» дпя обработки спучая, когда
                                                // функция дпя вызова не указана
        result.append(str)
    }

    result.append(postfix)
    return result.toString()
}
