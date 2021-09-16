package syntax.functions.type.lambda_func.example11

fun main() {
    val list = listOf(1, 2, 3, 4)
    println("1. result: ${list.map(::m).filter(::f)}")  //m1 m2 m3 m4 f1 f2 f3 f4
    println("2. result: ${list.asSequence().map(::m).filter(::f).toList()}") // m1 f1 m2 f2 m3 f3 m4 f4
    println("3. result: ${list.asSequence().filter(::f).map(::m).toList()}") // f1 f2 m2 f3 f4 m4
}

fun m(i: Int): Int {
    print("m$i ")
    return i
}

fun f(i: Int): Boolean {
    print("f$i ")
    return i % 2 == 0
}
