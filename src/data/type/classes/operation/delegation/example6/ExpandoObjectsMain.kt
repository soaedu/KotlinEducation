package data.type.classes.operation.delegation.example6

/**
 * Делегирование свойств широко применяется в объектах с динамически определяемым набором атрибутов.
 * Такие объекты иногда называют расширяемыми обоектами (expando objects)
 */
fun main() {
    val p = Person()
    val data = mapOf("name" to "Dmitry", "company" to "JetBrains")

    for ((attrName, value) in data) {
        p.setAttribute(attrName, value)
    }

    println(p.name)
}

/**
 * Определение свойства, хранящего свое значение в словаре
 */
// #1
/*class Person {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    val name: String
        get() = _attributes["name"]!!   // Извлечение атрибута из словаря вручную
}*/

/**
 * Делегированное свойство, хранящее свое значение в словаре
 *
 * В стандартной библиотеке определены функции-расширения getValue и setValue для стандартных интерфейсов Мар и
 * MutableMap. Имя свойства автоматически используется как ключ для доступа к значению в словаре.
 */
// #2
class Person {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes [attrName] = value
    }

    // Использовать словарь в роли объекта·делегата
    val name: String by _attributes
}
