package syntax.functions.type.lambda_func.example5

fun main() {
    /**
     * При желании лямбда-выражение можно вызывать напрямую
     */
    { println("1. ${(1+2)*4}") } ()

    /**
     * Лямбда-выражение можно сохранить в переменной, а затем обращаться к ней как к обычной функции
     * (вызывая с соответствующими аргументами)
     */
    val sum1: (Int, Int, Int) -> Double = { x: Int, y: Int, z:Int -> ((x+y)*z).toDouble() }
    println("2. ${sum1(1,2,4)}")

    /**
     * Если нужно заключить фрагмент кода в блок, используйте библиотечную функцию "run", которая выполнит переданное
     * ей лямбда-выражение
     */
    run { println("3. ${sum1(1,2,4)}") }


    val people = listOf(
            Person( "Alice", 29),
            Person( "Bob", 31)
    )

    /**
     * Поиск в коллекции вручную
     */
    findTheOldest(people)

    /**
     * Поиск в коллекции с помощью лямбда-выражения
     */
    println("5. ${people.maxByOrNull { it.age }}")
    // Если переписать этот код без всяких синтаксических сокращений, получится следующее
    println("5_1. ${people.maxByOrNull({p: Person -> p.age})}")
    // Этот код избыточен.
    //  1. в нем слишком много знаков препинания, что затрудняет чтение.
    //  2. тип легко вывести из контекста, поэтому его можно опустить.
    // И наконец, в данном случае не обязательно присваивать имя аргументу лямбда-выражения.
    // Синтаксис языка Kotlin позволяет вынести лямбда-выражение за круглые скобки, если оно является последним
    // аргументом вызываемой функции. В этом примере лямбда-выражение - единственный аргумент, поэтому его можно
    // поместить после круглых скобок.
    println("5_2. ${people.maxByOrNull() { p: Person -> p.age }}")
    // Когда лямбда-выражение является единственным аргументом функции, также можно избавиться от пустых круглых скобок
    println("5_3. ${people.maxByOrNull { p: Person -> p.age }}")
    // Ещё упростим синтаксис, избавившись от типа параметра.
    println("5_4. ${people.maxByOrNull { p -> p.age }}")
    // Использование имени параметра по умолчанию
    println("5_5. ${people.maxByOrNull { it.age }}")

    /**
     * Лямбда-выражения могут содержать несколько выражений! В таком случае их результат - последнее выражение
     */
    val sum2 = { x1: Int, y1: Int ->
        println("6. Computing the sum of $x1 and $y1...")
        x1 + y1
    }
    println("\tResult is: ${sum2(1, 2)}")
}

data class Person(val name: String, val age: Int)

fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null

    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }

    println("4. $theOldest")
}

