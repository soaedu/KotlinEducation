package data.type.arrays.example5

fun main(args: Array<String>) {
    args.forEachIndexed { index, element ->
        println("Argument $index is : $element")
    }
}