package data.type.generics.example6

/**
 * Вариантность: обобщенные типы и подтипы.
 *
 * Термин вариантность (variance) описывает, как связаны между собой типы с одним базовым типом и разными типовыми
 * аргументами: например, List<String> и List<Any>.
 *
 * Передача списка строк в функцию, ожидающую получить список объектов Any небезопасно, если функция добавляет или
 * заменяет элементы в списке, потому что можно нарушить совместимость типов.
 * Выбирая правильный интерфейс в зависимости от разновидности списка - изменяемый/неизменяемый, можно управлять этой
 * ситуацией.
 *  -> Если функция принимает неизменяемый список, ей можно передать список List с более конкретным типом элементов.
 *  -> Если список изменяемый, этого делать нельзя.
 */
fun main() {
    print("1. ")
    printContents(listOf("abc", "bac"))

    val strings = mutableListOf("abc", "bac")
    print("2. ")
 // addAnswer(strings)  // Ошибка на этапе компиляции:
                        //      Kotlin: Type mismatch: inferred type is MutableList<String> but MutableList<Any>
                        //      was expected
                        // Даже если бы эта строка скомпилировалась, ошибка возникла бы во время выполнения:
                        //      ClassCastException : Integer cannot Ье cast to String
    println(strings.maxByOrNull { it.length })
}

// Можно передать строку в функцию, ожидающую получить аргумент Any, потому что класс String наследует Any.
// Но когда Any и String выступают в роли типовых аргументов для интерфейса List, ситуация не так очевидна.
fun printContents(list: List<Any>) {
    println(list.joinToString())
}

// В данном функции все будет уже не так однозначно.
fun addAnswer(list: MutableList<Any>) {
    list.add(42)
}