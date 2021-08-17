package syntax.operators.operation.overload.example5

import java.time.LocalDate

/**
 * Операторы доступа к элементам коллекций и диапазонов, доступные для перегрузки:
 *  []      ->  транслируется в:
                    get  ->  map[key]
                    set  ->  mutableMap[key] = newValue
                и называется "оператором индекса".
                Эти методы уже определены в интерфейсах Мар и MutableMap.
                Операция доступа с применением квадратных скобок транслируется в вызов функции get
                    x[a, b]  -> x.get(a, b)
 * in       -> транслируется в contains
 *              используется для проверки вхождения объекта в коллекцию.
 *              Метод contains вызывается для объекта справа от in, а объект слева передается этому методу в аргументе
 *              Оператор in транслируется в вызов функции contains:
 *                  a in c  ->  c.contains(a)
 * in       -> транслируется в iterator, если он предназначен для выполнения итераций (цикл for)
 *              for (х in list) {...}, транслируются в вызов list.iterator(), который повторно вызывает методы
 *              hasNext() и next().
 *              В Kotlin этот метод - соглашение, то есть метод iterator можно определить как расширение.
 *              Это объясняет возможность итераций по обычным строкам Java: стандартная библиотека определяет
 *              функцию-расширение iterator в CharSequence, суперклассе, который наследует класс String.
 * ..       -> транслируется в rangeTo
 *              Вы можете реализовать поддержку этого оператора в своем классе. Но если класс реализует интерфейс
 *              Comparable, в этом нет необходимости: в таком случае диапазоны будут создаваться средствами стандартной
 *              библиотеки Kotlin. Библиотека включает функцию rangeTo, которая может быть вызвана для любого элемента,
 *              поддерживающего операцию сравнения:
 *                  operator fun <Т:Comparable<T>> T.rangeTo(that: Т): ClosedRange<T>
 *
 * Эти операции можно добавить в свои классы, действующие подобно коллекциям.
 */
fun main() {
    val pointArray = PointArray(2, 2)
    println("1_1. print pointArray: ")
    pointArray.printItems()
    println("1_2. print last point of the pointArray: ${pointArray[1, 1]}")

    val point1 = Point(10, 20)
    println("\n2_1. print value of point.x: ${point1[0]}")
    println("2_2. print value of point.y: ${point1[1]}")
    /*println("2_3. print error: ")
    print(point1[10])*/

    val point2 = MutablePoint(10, 20)
    point2[1] = 42
    println("\n3. print point with new \"y\" value: $point2")

    val rect = Rectangle(
        Point(10, 20),
        Point(50, 50)
    )
    println("\n4_1. rectangle contains specified point: ${Point(20, 30) in rect}")
    println("4_2. rectangle contains specified point: ${Point(5, 5) in rect}")

    val now = LocalDate.now()
    // Соэдает 10·дневный диапазон, начиная от текущей даты
    // Компилятор преобразует выражение now..now.plusDays(10) в now.rangeTo(now.plusDays(10)).
    // Функция rangeTo не является членом класса LocalDate это функция-расширение для Comparable.
    val vacation = now..now.plusDays( 10)
    // Проверяет принадлежность конкретной дать� этому диапазону
    val result = now.plusWeeks(1) in vacation
    println("\n5_1. check if after a week will be a vacation: $result")

    val n = 9
    // Оператор rangeTo имеет более низкий приоритет, чем арифметические операторы, поэтому рекомендуется пользоваться
    // круглыми скобками, чтобы избежать путаницы
    println("5_2. print range: ${0..(n + 1)}")
    // Выражение 0..n.forEach{} не будет компилироваться.
    // Чтобы исправить эту проблему, диапазон нужно заключить в круглые скобки
    print("5_3. print range: ")
    (0..n).forEach { print(it) }

    print("\n\n6_1. print string with iterator: ")
    for (c in "abc") {
        print(c)
    }

    val newYear = LocalDate.ofYearDay( 2017, 1)
    val daysOff = newYear.minusDays(1)..newYear
    print("\n6_2. print daysOff items with iterator: ")
    for (dayOff in daysOff) {
        print("$dayOff ")
    }
}

data class Point(val x: Int, val y: Int) {
    /**
     * Определяем метод get с одним параметром.
     */
    operator fun get(index: Int): Int {
        return when (index) {
            0 -> x
            1 -> y
            else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
        }
    }
}
data class PointArray(val rowSum: Int, val columnSum: Int) {
    private val matrix: Array<Array<Point>> = Array(rowSum) {
            i -> Array(columnSum) {
                j -> Point((i*2+j) * 5, (i*2+j) * 10)
            }
    }

    /**
     * Определяем метод get с несколькими параметрами.
     */
    operator fun get(rowIndex: Int, colIndex: Int): Point {
        return matrix[rowIndex][colIndex]
    }

    fun printItems() {
        for (i in matrix[rowSum-1].indices) {
            for (j in matrix[columnSum-1].indices) {
                print("\t\t${matrix[i][j]}")
            }
            println()
        }
    }
}

data class MutablePoint(var x: Int, var y: Int)

/**
 * Определим функцию, позволяющую изменять значение элемента по индексу с применением синтаксиса квадратных скобок
 *
 * Операция присваивания с применением квадратных скобок транслируется в вызов функции set
 *      x[a, b] = c  ->  x.set(a, b, c)
 * Последний параметр в set получает значение, указанное справа от оператора присваивания, а другие аргументы
 * соответствуют индексам внутри квадратных скобок.
 */
operator fun MutablePoint.set(index: Int, value: Int) {
    when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("Invalid coordinate: $index")
    }
}

data class Rectangle(val upperLeft: Point, val lowerRight: Point)
/**
 * Определим функцию, которая даст возможность использовать оператор "in" для проверки вхождения точки в границы
 * прямоугольника.
 *
 * Задействуем функцию until из стандартной библиотеки и с её помощью конструируем открытыи диапазон, которыи затем
 * используем для проверки принадлежности точки этому диапазону.
 *
 * Открытый диапазон - это диапазон, не включающий конечного значения.
 * Например, если сконструировать обычный (закрытый) диапазон 10..20, он будет включать все значения от 10 до 20,
 * в том числе и 20. Открытый диапазон от 10 до 20 включает число от 10 до 19, но не включает 20.
 *
 * Класс прямоугольника обычно определяется так, что правая нижняя точка не считается частью прямоугольника, поэтому
 * используем открытые диапазоны.
 */
operator fun Rectangle.contains(p: Point): Boolean {
    // Создает диапазон и проверяет принадлежность ему координаты "x"
    return  p.x in upperLeft.x until lowerRight.x &&
            // Использует функцию "until" дпя создания открытого диапазона
            p.y in upperLeft.y until lowerRight.y
}

// Эта библиотечная функция поэволяет выполнять итерацию по строке
//operator fun CharSequence.iterator(): CharIterator {
//
//}

// Реализация итератора по диапазону дат
operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    // Этот объект реализует интерфейс Iterator дnя поддержки итераций по элементам LocalDate
    object : Iterator<LocalDate> {
        var current = start

        // Для дат испопьэуется соглашение compareТо
        override fun hasNext() = current <= endInclusive

        override fun next() = current.apply { // Возвращает текущую дату как результат перед ее изменением
            // Увеличивает текущую дату на один день
            current = plusDays(1)
        }
    }