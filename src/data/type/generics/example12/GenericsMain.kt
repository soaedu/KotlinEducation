package data.type.generics.example12

fun main(args: Array<String>) {
    println("\nObject#1: ")
    GenericsExample<String>("JAVA")

    println("\nObject#2: ")
    GenericsExample<Int>(10)
}

// #1
// class GenericsExample<T>(input:T) {

// #2
class GenericsExample<out T>(input:T) {
    init {
        println("\tI am getting called with the value "+input)
    }
}