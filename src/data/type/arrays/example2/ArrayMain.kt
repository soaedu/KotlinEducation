package data.type.arrays.example2

/**
 * Создание массива строк.
 *
 * Конструктор класса Array принимает размер массива и лямбда-выражение, после чего инициализирует каждый элемент
 * с помощью этого лямбда-выражения.
 */
fun main() {
    val letters = Array<String>(26) { i-> ('a' + i).toString()}
    println(letters.joinToString(""))
}
