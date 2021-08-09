package syntax.functions.type.inline_func.example4

fun main() {
    print("1. ")
    repeat(10) { print("Hello ") }

    print("\n2. ${'a' * 3}")
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}