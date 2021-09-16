package data.type.classes.type.object_class.companion_object.example6

/**
 * Реализация интерфейса в объекте-компаньоне
 *
 * Как любые другие объявления объектов, объекты-компаньоны могут реализовать интерфейсы.
 * Предположим, что в нашей системе много типов объектов, включая Person и хочется обеспечить единый способ создания
 * объектов всех типов.
 * Допустим, есть интерфейс JSONFactory для объектов, которые можно десериализовать из формата JSON, и все объекты
 * в системе должны создаваться с помощью этой фабрики.
 * Реализуем этот интерфейс в классе Person.
 */
fun main() {
    // Передача объекта-компаньона в функцию
    val person = loadFromJSON(Person, "{ name: 'Alex'}")
    println("Person name: ${person.name}")
}

interface JSONFactory<T> {
    fun fromJSON(text: String) : T
}

class Person (val name: String) {
    // Объект·компаньон, реализующий интерфейс
    companion object : JSONFactory<Person> {
        override fun fromJSON(text: String) : Person {
            val name = text.substringAfter("name:")
                    .replace("'", "")
                    .replace("}", "")
                    .trim()

            return Person(name)
        }
    }
}

// Функция, использующая абстрактную фабрику для загрузки сущностей
fun <T> loadFromJSON(factory: JSONFactory<T>, jsonText: String): T {
    return factory.fromJSON(jsonText)
}