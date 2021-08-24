package generics.example2

// #1
/*
fun main(args: Array<String>) {
    var elems: List<Any> = getItems()   // List<Item>
    elems = elems inject getAds()       // List<Ad>
    // Does not work
    // List<Any> is not a supertype of List<Ad>
}

class List<T> { ... }

inline fun <E> List<E>.inject(other: List<E>): List<E> {
    var res = listOf<E>()
    res += this.slice(0..this.size / 2)
    res += other
    res += this.slice(this.size / 2 + 1..this.lastIndex)
    return res
}
*/

/*fun kaboom() {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val anys: Array<Any> = arrayOf("", "", "")
    copy(ints, anys) 	// Does not work
}

fun copy(from: Array<Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}*/

/*
fun copy(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}
*/

/*
// #1
fun <From, To> copy(from: Array<out From>, to: Array<To>) { ... }

// #2
fun <From: To, To> copy(from: Array<out From>, to: Array<To>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}
*/


fun <From, To> copyNonNulls(from: Array<out From>, to: Array<To>)
        where From: To,		/* From <: To */
              To: Any	{
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}
