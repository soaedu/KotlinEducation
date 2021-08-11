package syntax.functions.type.inline_func.scope_func.apply.example4

/**
 * В случае, когда нужно, чтобы результатом вызова стал сам объект-получатель, а не результат выполнения
 * лямбда-выражения, может пригодиться библиотечная функция apply.
 *
 * Она работает почти так же, как with, - разница лишь в том, что apply() всегда возвращает объект, переданный в
 * аргументе (другими словами, объект-получатель).
 */
fun main() {
    println("1. ${alphabet1()}")
    println("2. ${alphabet2()}")
}

fun alphabet1() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}.toString()

/*
// Применение функции apply() для инициализации экземпляра TextView
fun createViewWithCustomAttributes(context : Context) = TextView(context).apply {
    text = "Sample Text"
    textSize = 20.0
    setPadding(10, 0, 0, 0)
}*/

// Использование функции buildString() для генерации алфавита
// Эта функция позаботится о создании экземпляра StringBuilder и вызовет метод toString().
// Она ожидает получить лямбда-выражение с получателем, а получателем всегда будет экземпляр StringBuilder.
fun alphabet2() = buildString {
    for (letter in 'А'..'Z') {
        append(letter)
    }
    append( "\nNow I know the alphabet!")
}
