package syntax.functions.function_type.higher_order_func.example_5

fun main() {
    val logs = getLogs()

    // #1
    // Use filters specified explicitly (multiple duplicate code)
    println(
        "\nPrint average duration for user with OS:" +
        "\n\tWindows: ${logs.filter { it.os == OS.WINDOWS }.map { it.duration }.average()}" +
        "\n\tLinux: ${logs.filter { it.os == OS.LINUX }.map { it.duration }.average()}" +
        "\n\tMAC: ${logs.filter { it.os == OS.MAC }.map { it.duration }.average()}" +
        "\n\tiOS: ${logs.filter { it.os == OS.IOS }.map { it.duration }.average()}" +
        "\n\tAndroid: ${logs.filter { it.os == OS.ANDROID }.map { it.duration }.average()}"
    )

    // #2
    // Use higher-order filtering function with short predicate passed on it.
    println(
        "\nPrint average duration for user with OS:" +
        "\n\tWindows: ${logs.averageDurationFor { it.os == OS.WINDOWS }}" +
        "\n\tLinux: ${logs.averageDurationFor { it.os == OS.LINUX }}" +
        "\n\tMAC: ${logs.averageDurationFor { it.os == OS.MAC }}" +
        "\n\tiOS: ${logs.averageDurationFor { it.os == OS.IOS }}" +
        "\n\tAndroid: ${logs.averageDurationFor { it.os == OS.ANDROID }}"
    )
}

fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) = filter(predicate)
                                                                            .map(SiteVisit::duration)
                                                                            .average()