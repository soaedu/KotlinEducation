package data.type.standard_type.interface_type.example_1

import java.io.InputStream
import java.io.OutputStream

fun main() {
    // #1
    val document = DocumentImpl()
    println(
        "Show file info:" +
        "\n\tdescription: ${document.getDescription()}" +
        "\n\tname: ${document.name}" +
        "\n\tsize: ${document.size}" +
        "\n\tversion: ${document.version}"
    )

    // #2
    // Apply 'polymorphism'
    val car = Car()
    applyMove(car)

    val aircraft = Aircraft()
    applyMove(aircraft)
}

interface Document {
    val name: String
        get() = "NoName"                // property with default value

    val size: Long                      // abstract property
    val version: Long                   // abstract property

    fun load(input: OutputStream)       // abstract method
    fun save(input: InputStream)        // abstract method

    fun getDescription(): String {      // method with default implementation
        return "Document $name has $size byte(s)"
    }
}

// Implement abstract properties in primary constructor
//class DocumentImpl(override val size: Long, override val version: Long) : Document {

class DocumentImpl : Document {

    // Implement properties in the body
    override val size: Long
        get() = 0
    override val version: Long
        get() = 0

    override fun load(input: OutputStream) {
        println("Load document...")
    }

    override fun save(input: InputStream) {
        println("Save document...")
    }
}

interface Movable {
    fun move()
}

class Car : Movable {
    override fun move() {
        println("Car is moving...")
    }
}

class Aircraft : Movable {
    override fun move() {
        println("Aircraft is flying...")
    }
}

fun applyMove(obj: Movable) = obj.move()