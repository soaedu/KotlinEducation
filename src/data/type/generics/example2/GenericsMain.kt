package data.type.generics.example2

/**
 * Ограничения типовых параметров позволяют ограничивать круг допустимых типов, которые можно использовать в качестве
 * типовых аргументов для классов и функций.
 *
 * Когда какой-то тип определяется как верхняя граница для типового параметра, в качестве соответствующих типовых
 * аргументов должен указываться либо именно этот тип, либо его подтипы.
 */
fun main() {
    println("1. ${listOf(1, 2, 3).sum()}")
    println("2. ${oneHalf(3)}")
    println("3. ${max("kotlin", "java")}")
    // println("3. ${max("kotlin", 42)}")      // Этот код не будет компилироваться

    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println("4. $helloWorld")
}

// Функция, вычисляющая сумму элементов списка.
// Может использоваться со списками List<Int> или List<Double>, но не со списками, например, List<String>.
/*fun <T: Number> List<T>.sum(): T {
    var sum: T = 0
    for (element in this) {
        sum += element
    }
    return sum
}*/

fun <T: Number> oneHalf(value: T): Double {
    return value.toDouble() / 2.0
}

// Объявление функции с ограничением для типового параметра
fun <T: Comparable<T>> max(first: T, second: T): T {    // Аргументы этой функции должны быть элементами,
                                                        // поддрживающими сравнение
    return if (first > second) first else second
}

// Определение нескольких ограничений для типового параметра
fun <T> ensureTrailingPeriod(seq: T)
    where T: CharSequence, T: Appendable {              // Список ограничений дnя типового параметра
    if (!seq.endsWith('.')) {                      // Вызов функции-расширения, объявленной дnя интерфейса
                                                        // CharSequence
        seq.append('.')                                 // Вызов метода из интерфейса Appendable
    }
}
