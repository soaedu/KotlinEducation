package syntax.functions.type.higher_order_func.example5

/**
 * Устранение повторяющихся фрагментов с помощью лямбда-выражений
 *
 * Типы функций и лямбда-выражения вместе - это великолепный инструмент для создания кода многократного использования.
 * Многие виды повторений кода, которые обычно можно предотвратить только за счет использования мудреных конструкций,
 * теперь легко устранить с помощью лаконичных лямбда-выражений.
 */
fun main() {
    val log = listOf(
        SiteVisit( "/", 34.0, OS.WINDOWS),
        SiteVisit( "/", 22.0, OS.MAC),
        SiteVisit( "/login", 12.0, OS.WINDOWS),
        SiteVisit( "/signup", 8.0, OS.IOS),
        SiteVisit( "/", 16.3, OS.ANDROID)
    )

    // Анализ данных, описывающих посещение сайта, с применением жестко заданных фильтров
    val averageWindowsDuration = log
            .filter { it.os == OS.WINDOWS }
            .map(SiteVisit::duration)
            .average()

    println("1. averageWindowsDuration: $averageWindowsDuration")

    println("2. averageDurationFor:" +
            "\n\tWINDOWS: ${log.averageDurationFor(OS.WINDOWS)}" +
            "\n\tMAC: ${log.averageDurationFor(OS.MAC)}"
    )

    // Анализ данных, описывающих посещение сайта, с применением сложного, жестко заданного фильтра
    val averageMobileDuration = log
            .filter { it.os in setOf(OS.IOS, OS.ANDROID) }
            .map(SiteVisit::duration)
            .average()
    println("3. averageMobileDuration: $averageMobileDuration")

    println("4. averageDurationFor using higher-ordered function: " +
                "\n\tmobile: ${log.averageDurationFor { it.os in setOf(OS.ANDROID, OS.IOS) }}" +
                "\n\tiOS with \"/sighup\": ${log.averageDurationFor {it.os == OS.IOS && it.path == "/signup" }}"
    )
}

/**
 * Определение данных, описывающих посещение сайта
 */
data class SiteVisit(
    val path: String,
    val duration: Double,
    val os : OS
)
enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

/**
 * Представим, что нам нужно вычислить ту же статистику для пользователей МAC.
 * Чтобы избежать повторения кода, тип платформы можно выделить в параметр.
 *
 * Устранение повторений с помощью обычной функции
 */
fun List<SiteVisit>.averageDurationFor(os: OS) = filter { it.os == os }
                                                    .map(SiteVisit::duration)
                                                    .average( )

/**
 * Устранение повторений с помощью функции высшего порядка
 *
 * Типы функций помогают избавиться от повторяющихся фрагментов кода.
 * Лямбда-выражения позволяют извлекать не только повторяющиеся данные, но также поведение.
 */
fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) = filter(predicate)
                                                                                .map(SiteVisit::duration)
                                                                                .average()
