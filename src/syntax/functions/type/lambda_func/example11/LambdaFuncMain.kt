package syntax.functions.type.lambda_func.example11

import java.io.File

/**
 * Последовательность также можно создать вызовом функции generateSequence().
 * Она вычисляет следующий элемент последовательности на основании предыдущего.
 *
 * Вы создаете последовательность, предоставляя первый элемент и способ получения каждого последующего элемента.
 */
fun main() {
    // Подсчитаем сумму всех натуральных чисел до 100.
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    // naturalNumbers и numbersTo100 - последовательности с отложенным выполнением операций
    // Все отложенные операции выполнятся при обращении к sum()
    println("1. ${numbersTo100.sum()}")

    // Другой распространенный вариант использования - это последовательность родителей.
    // Если у элемента есть родитель того же типа (например, человек или Jаvа-файл), вас могут заинтересовать
    // свойства всех его предков в последовательности.
    val file = File("/home/ostin/.config/Android Open Source Project/Emulator.conf")
    println("2. ${file.insideHiddenDirectory()}")
    println("3. ${file.getHiddenDirectory()}")
}

fun File.insideHiddenDirectory() = generateSequence(this) { it.parentFile }.any { it.isHidden }
fun File.getHiddenDirectory() = generateSequence(this) { it.parentFile }.find { it.isHidden }
