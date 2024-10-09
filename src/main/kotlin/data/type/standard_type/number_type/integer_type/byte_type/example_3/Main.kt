package data.type.standard_type.number_type.integer_type.byte_type.example_3

import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path

fun main() {
    val path = "E:\\Edu\\Computer_disciplines\\0_Language\\Kotlin\\2_Code\\KotlinEducation\\src\\main\\kotlin\\data" +
            "\\type\\standard_type\\number_type\\integer_type\\byte_type\\example_3\\TextFile.txt"
    val filePath = File(path)
    readFile(filePath.toPath())
}

// Use 'byte' to read the data from the resource available by specified 'path'
fun readFile(path: Path): Unit {
    val input = Files.newInputStream(path)

    // #1
    // Manually close used resources
    /*try {
        var byte = input.read()
        while (byte != -1) {
            println(byte)
            byte = input.read()
        }
    } catch (e: IOException) {
        println("Error reading from file. Error was ${e.message}")
    } finally {
        input.close()
    }*/

    // #2
    // Use 'use' method to read first byte and automatically close the resource
    val firstByte = input.use(
        { input.read() }
    )
    println("Show the first byte of the file:" +
            "\n\tfirstByte = $firstByte"
    )
}
