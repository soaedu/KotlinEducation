package syntax.operators.operation.overload.example2

/**
 * Составные операторы, доступные для перегрузки:
 *  *=      -> timesAssign
 *  /=      -> divAssign
 *  %=      -> modAssign
 *  +=      -> plusAssign
 *  -=      -> minusAssign
 *
 *  Операторы += и -= работают с изменяемыми коллекциями, модифицируя их на месте, а для неизменяемых коллекций
 *  возвращают копию с модификациями.
 *  То есть операторы += и - = будут работать с неизменяемыми коллекциями, только если переменная со ссылкой объявлена
 *  как var.
 */
fun main() {
    var point = Point(1, 2)
    point += Point(3, 4)
    println("1. point: $point")

    val numbers = ArrayList<Int>()
    numbers += 42
    println("2. first arrayList item: ${numbers[0]}")

    val list = arrayListOf(1, 2)
    list += 3
    val newList = list + listOf(4, 5)
    println("3. \tlist:\t$list \n\tnewList:$newList")

    val list1 = listOf(1, 2, 3)
    var list2 = list1
    list2 += 4                                          // new list will be created
    println("4. \tlist1:\t$list1 \n\tlist2:$list2")

    var list3 = listOf(1, 2, 3)
    val list4 = list3
    list3 += 4                                          // new list will be created
    println("5. \tlist3:\t$list3 \n\tlist4:$list4")

    val list5 = mutableListOf(1, 2, 3)
    val list6 = list5
    list5 += 4
    println("6. \tlist5:\t$list5 \n\tlist6:$list6")     // existing list will extend
}

/**
 * Определение оператора "plus"
 */
data class Point(val x: Int, val y: Int) {
    // Определение функции с именем «plus», реапизующее оператор
    operator fun plus(other: Point): Point {
        // Скпадывает координаты и возвращает новую точку
        return Point(x + other.x, y + other.y)
    }
}

operator fun <T> MutableCollection<T>.plusAssign(element: T) {
    this.add(element)
}
