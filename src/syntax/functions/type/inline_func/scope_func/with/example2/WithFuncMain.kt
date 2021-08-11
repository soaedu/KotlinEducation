package syntax.functions.type.inline_func.scope_func.with.example2

/**
 * Структура with() выглядит как особая конструкция, но это лишь функция, которая принимает два аргумента:
 *      1. объект stringBuilder
 *      2. лямбда-выражение.
 * Здесь используется соглашение о передаче лямбда-выражения за круглыми скобками, поэтому весь вызов выглядит как
 * встроенная конструкция языка. То же самое можно было бы записать кaк
 *      with (stringBuilder, { ... })
 * однако такой код труднее читать.
 *
 * Функция with() преобразует первый аргумент в получатель лямбда-выражения во втором аргументе.
 * Вы можете явно обращаться к этому получателю через ссылку this.
 * С другой стороны, можно опустить ссылку this и обращаться к методам или свойствам текущего объекта без
 * дополнительных квалификаторов.
 *
 * Функция with() возвращает результат выполнения лямбда-выражения, т.е. результат последнего выражения в теле
 * лямбда-функции.
 */
fun main() {
    println("\nAlphabet (regular call): ${alphabetRegular()}")
    println("\nAlphabet (\"with{}\" call): ${alphabetWith()}")
}

fun alphabetRegular(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

// #1
/*fun alphabetWith(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        append("\nNow I know the alphabet!")
        this.toString()
    }
}*/
// #2
fun alphabetWith(): String = with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
        toString()
}