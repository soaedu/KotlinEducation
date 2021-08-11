package data.type.collections.example3

import java.io.BufferedReader
import java.io.File
import java.io.StringReader
import java.lang.NumberFormatException

fun main() {
    val filePath = "/home/ostin/1_EDUCATION/1_Computer_Disciplines/7_Programming/1_Languages/2_Kotlin/2_Code/2_Projects/KotlinEducation/KotlinEducationApp/src/data/type/collections/example3/Data.txt"
    val file = File(filePath)
    println("1. ${readNumbers(file.bufferedReader())}")

    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    print("2. ")
    addValidNumbers1(numbers)
    print("3. ")
    addValidNumbers2(numbers)
}

fun readNumbers(reader: BufferedReader): List<Int?> {
    // Создание списка значений типа Int с поддержкой null
    val result = ArrayList<Int?>()

    for (line in reader.lineSequence()) {
        result.add(
            try {
                // Добавление в список целочисленного значения (не равного null)
                line.toInt()
            } catch (error: NumberFormatException) {
                // Добавпение значения null в список, поскопьку текущая строка не может быть преобразована в чиспо
                null
            }
        )
    }

    return result
}

fun addValidNumbers1(numbers: List<Int?>) {
    var sumOfValidNumbers = 0
    var invalidNumbers = 0

    // Чтение из списка значения, которое может оказаться равным null
    for (number in numbers) {
        // Проверка значения на null
        if (number != null) {
            sumOfValidNumbers += number
        } else {
            invalidNumbers++
        }
    }
    println("\tSum of valid numbers: $sumOfValidNumbers")
    println("\tInvalid numbers: $invalidNumbers")
}

fun addValidNumbers2(numbers: List<Int?>) {
    // Коллекция validNumbers имеет тип List<Int>, потому что фильтрация гарантирует, что коллекция не будет содержать
    // значений null.
    val validNumbers = numbers.filterNotNull()

    println("\tSum of valid numbers: ${validNumbers.sum()}")
    println("\tInvalid numbers: ${numbers.size - validNumbers.size}")
}