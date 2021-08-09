package syntax.functions.type.lambda_func.example6

import syntax.functions.type.lambda_func.example5.Person

fun main() {
    val people = listOf( Person( "Alice", 29), Person( "Bob", 31))

    /**
     * Выражение называется ссылкой на член класса (member reference) и обеспечивает короткий синтаксис создания
     * значения функции, вызывающего ровно один метод или обращающегося к свойству.
     * Двойное двоеточие отделяет имя ссылки на член класса от имени члена класса, на который нужно сослаться
     * (метод или свойство).
     *
     * Поиск с использованием ссылки на член
     */
    println("1. ${people.maxByOrNull(Person::age)}")

    /**
     * Можно создать ссылку на функцию верхнего уровня (и не являющуюся членом класса)
     */
    run(::salute)

    /**
     * Это лямбда-выражение делегирует работу функции sendEmail
     */
    val action = { person: Person, message: String -> sendEmail(person, message) }
    action(Person("Jora", 35), "Job CV")

    /**
     * Вместо него можно использовать ссылку на функцию
     */
    val nextAction = ::sendEmail

    /**
     * Можно сохранить или отложить операцию создания экземпляра класса с помощью ссылки на конструктор.
     * Чтобы сформировать ссылку на конструктор, нужно указать имя класса после двойного двоеточия.
     */
    val createPerson = ::Person // Операция создания экземмяра Person сохраняется в переменную
    val p = createPerson( "Alice" , 29)
    println("4. $p")

    /**
     * Ссылку можно получить и на функцию-расширение
     */
    val p1 = Person("Gogi", 62)
    val predicate = Person::isAdult
    // println("5. $predicate")
    println("5. ${p1.name} is adult: ${predicate(p1)}")

    /**
     * В Kotlin 1.0 всегда требуется передавать экземпляр класса при обращении к его методу или свойству по ссылке.
     * В Kotlin 1.1 планируется добавить поддержку связанных ссылок, позволяющих использовать специальныи синтаксис для
     * захвата ссылки на метод конкретного экземпляра класса
     */
    val p2 = Person("Alex", 28)
    val personsAgeFunction = Person::age
    println("6. ${p2.name} age is: ${personsAgeFunction(p2)}")

    val alexAgeFunction = p2::age
    println("7. Alex age is: ${alexAgeFunction()}")  // Связанная ссылка, доступная в Kotlin 1.1

    // Обратите внимание, что функция:
    //  * personsAgeFunction принимает один аргумент (и возвращает возраст конкретного человека)
    //  * alexAgeFunction это функция без аргументов (возвращает возраст конкретного человека).
    //  До Kotlin 1.1 вместо использования связанной ссылки на метод р::age нужно было написать
    //  лямбда-выражение { р.age }.
}

fun salute() = println("2. Salute!")

fun sendEmail(person: Person, message: String) =
        println("3. ${person.name} is sending email with the message: \"$message\"")

fun Person.isAdult() = age >= 21