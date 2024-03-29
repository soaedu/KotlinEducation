package syntax.destructuring_declaration.example1

/**
 * Мультидекларации (destructuring declarations) позволяют распаковать единое составное значение и использовать его
 * для инициализации нескольких переменных.
 *
 * Скрытая работа мулътидеклараций основана на принципе соглашений.
 * Для инициализации каждой переменной в мультидекларации вызывается функция с именем componentN, где N - номер
 * позиции переменной в объявлении.
 *      val (a, b) = p  -> val a = p.component1()
 *                         val b = p.component2()
 *
 * Для класса данных компилятор сгенерирует функции componentN для каждого свойства, объявленного в основном
 * конструкторе. Можно объявить такие функции вручную в других классах, не являющихся классами данных.
 *      class Point(val х: Int, val у: Int) {
 *          operator fun component1() = х
 *          operator fun component2() = у
 *      }
 *
 * Невозможно объявить бесконечное количество таких функций componentN, чтобы можно было использовать этот синтаксис
 * для работы с произвольными коллекциями. Но обычно в этом нет никакой необходимости. Стандартная библиотека позволяет
 * использовать этот синтаксис для извлечения первых пяти элементов из контейнера.
 *
 * Ещё более простой способ возврата нескольких значений из функций дают классы Pair и Triple из стандартной библиотеки.
 * В этом случае код получается менее выразительным, потому что эти классы не позволяют узнать смысл возвращаемого
 * объекта, зато более лаконичным, потому что отпадает необходимость объявлять свой класс данных.
 *
 * Мультидекларации могут использоваться не только как инструкции верхнего уровня в функциях, но и в других местах, где
 * допускается объявление переменных - например, в циклах. Один из интересных приемов - перечисление элементов словаря
 * в цикле for.
 */
fun main() {
    val point1 = Point(10, 20)
    val (x, y) = point1 // Объявляются переменные х и у и инициализируются компонентами о6ьекта р
    println("1. variables after applying destructuring declaration: " +
            "\n\tx: $x, y: $y")

    // Использует синтаксис мупыидеклараций для извлечения значений
    val (name, ext) = splitFilename( "example.kt")
    println("2. variables after applying destructuring declaration to \"example.kt\": " +
            "\n\tname: $name, extension: $ext")

    // Перечисление элементов словаря в цикле for
    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    println("3. print map items applying destructuring declaration:")
    printEntries(map)
}

data class Point(val x: Int, val y: Int)

// Объявление класса данных дпя хранения значений
data class NameComponents(val name: String, val extension: String)

// Возврат экземпляра класса данных из функции
// #1
/*fun splitFilename(fullName: String): NameComponents {
    val result = fullName.split('.', limit = 2)
    return NameComponents(result[0], result[1])
}*/

// Усовершенствуем метод splitFilename(), приняв во внимание, что функции componentN имеются в массивах и коллекциях.
// Это может пригодиться при работе с коллекциями, размер которых известен заранее. Именно такой случай - функция
// split(), возвращающая список с двумя элементами.
// #2
fun splitFilename(fullName: String): NameComponents {
    val (name, extension) = fullName.split('.', limit = 2)
    return NameComponents(name, extension)
}

// Использование мультидекларации для обхода элементов словаря
// В этом примере используются два соглашения Kotlin:
//      одно - для организации итерации по содержимому объекта,
//      другое - для поддержки мультидеклараций.
// Стандартная библиотека Kotlin включает функцию-расширение iterator для словарей, которая возвращает итератор
// для обхода элементов словаря.
fun printEntries(map: Map<String, String>) {
    // Мультидекларация в объявлении цикла
    for ((key, value) in map) {
        println("\t$key -> $value")
    }

    // В Мар.Entry имеются также функции-расширения component1 и component2, которые возвращают ключ и значение
    // соответственно. В результате предыдущий цикл транслируется в следующии эквивалентныи код:
    for (entry in map.entries) {
        val key = entry.component1()
        val value = entry.component2()
        // ...
    }
}