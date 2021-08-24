package data.type.generics.example13

fun <T> anyToString(value: T): String = value.toString()

class ValueWrapper<T>(val value: T) {
    // #1
    // val valueAsString = value.toString()

    // #2
    val valueAsString = anyToString(value)

    fun <R> convertTo(): R = value as R
}

/*fun <T> List<T>.println() {
    val strings = this as List<String>  // Warning
    for (str in strings)
        println(str)
}*/

/*
fun boom() {
    val strs = mutableListOf<String>()
    val objs: MutableList<Any> = strs   // Does not work!
    objs.add(1)
    val s: String = strs[0]
}
*/

// covariation
/*
class T {}

class T1: T{}

val arg1:T = 1
val arg2:T1 = 2

val result1: R = getResult(arg1)
val result2: R = getResult(arg2)

fun getResult(arg: T): R = return 0
fun getResult(arg: T1): R = return 0

// #2
class List<out T> {
    fun tryToSneakSomeElementIn(elem: T) {
        // Does not work
        // Compiler denies T in non-out position
    }
}
*/

// contrvariation
/*
class R {}

class R1: R{}

val result1: R = getResult()
val result2: R1 = getResult()

fun getResult(): R = return 0

// №2
interface Processor<in T> {
    fun process(item: T): Unit = TODO()
}
fun processorStuff() {
    val pUniversal: Processor<Any> =
        object: Processor<Any> {
            override fun process(item: Any) = TODO()
        }
    val pString: Processor<String> = pUniversal
}
*/

