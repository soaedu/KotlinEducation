package data.type.classes.operation.delegation.example4

/**
 * Часто бывает нужно добавить поведение в другой класс, даже если он не предназначен для наследования.
 * Для этого применяется шаблон <Декоратор>. Он создает новый класс с тем же интерфейсом, что у оригинального класса,
 * и сохраняет экземпляр оригинального класса в поле нового класса.
 * Методы, поведение которых должно остаться неизменным, просто передают вызовы оригинальному экземпляру класса.
 * Недостаток такого подхода - большой объем шаблонного кода.
 *
 * К счастью, при использовании Kotlin писать столько кода не нужно, потому что он предоставляет полноценную поддержку
 * делегирования на уровне языка. Всякий раз, реализуя интерфейс, вы можете делегировать реализацию другому объекту,
 * добавив ключевое слово "by".
 */
fun main() {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 2))

    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
}

// #1
// Вот сколько кода понадобится декоратору, чтобы реализовать простой интерфейс Collection
// даже притом, что он не изменяет поведения исходного класса.
/*class DelegatingCollection<T> : Collection<T> {
    private val innerList = arrayListOf<T>( )

    override val size : Int
        get() = innerList.size
    override fun isEmpty(): Boolean = innerList.isEmpty()
    override fun contains(element: T): Boolean = innerList.contains(element)
    override fun iterator() : Iterator<T> = innerList.iterator()
    override fun containsAll(elements : Collection<T>) : Boolean = innerList.containsAll(elements)
}*/

// #2
// При использовании Kotlin писать столько кода не нужно, потому что он предоставляет полноценную
// поддержку делегирования на уровне языка.
// Всякий раз, реализуя интерфейс, вы можете делегировать реализацию другому объекту, добавив ключевое слово "by"
class DelegatingCollection<T>(
        innerList: Collection<T> = ArrayList<T>()
) : Collection<T> by innerList {}

class CountingSet<T> (
        val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}