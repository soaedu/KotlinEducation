package syntax.functions.type.lambda_func.example9

import syntax.functions.type.lambda_func.example5.Person

fun main() {
    val canBeInClub27 = { p: Person -> p.age <= 27 }
    val listOfPeople = listOf(
            Person("Billy", 23),
            Person("Bobby", 33),
            Person("Buddy", 13)
    )

    /**
     * Все ли элементы удовлетворяют этому предикату
     */
    println("1. ${listOfPeople.all(canBeInClub27)}")

    /**
     * Хотя бы один подходящий элемент
     */
    println("2. ${listOfPeople.any(canBeInClub27)}")

    /**
     * Выражение !аll (<<Не все>>) с условием можно заменить выражением any с противоположным условием, и наоборот.
     * Чтобы сделать код более понятным, выбирайте функцию, не требующую знака отрицания перед ней
     */
    val listOfNumbers = listOf(1, 2, 3)
    println("3. ${!listOfNumbers.all { it == 3 }}") // Символ отрицания трудно заметить, лучше использовать «any»
    println("4. ${listOfNumbers.any { it != 3 }}") // Усповие в этом аргументе поменялось на противоположное

    /**
     * Если требуется узнать, сколько элементов удовлетворяет предикату, используите "count"
     */
    println("5. ${listOfPeople.count(canBeInClub27)}")

    /**
     * Чтобы найти элемент, удовлетворяющий предикату, используйте функцию "find"
     * Вернет первый найденный элемент, а не все, которые удовлетворяют предикату.
     */
    println("6. ${listOfPeople.find(canBeInClub27)}")

    val isEven = { i: Int -> (i%2) == 0 }
    val intList = listOf(1, 2, 3, 4)

    println("7. has at least one even number: ${intList.any(isEven)}")
    println("8. show all even numbers: ${intList.filter(isEven)}")

    fun isEven(i: Int): Boolean = (i%2) == 0
    println("9. has at least one even number: ${intList.any(::isEven)}")    // Несвязанная ссылка, т.к. указывает на
    println("10. show all even numbers: ${intList.filter(::isEven)}")       // функцию расширение, а не на конкретный
                                                                            // экземпляр класса.
}