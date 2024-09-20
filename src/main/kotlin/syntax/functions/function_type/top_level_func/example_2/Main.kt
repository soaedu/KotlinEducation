package syntax.functions.function_type.top_level_func.example_2

fun main() {
    println(
        "Show some logs with message and level"
    )
    printLog(LogLevel.LOADING, "Loading...")
    printLog(LogLevel.ERROR, "\tConnection is lost")
    printLog(LogLevel.LOADING, "Loading...")
    printLog(LogLevel.LOADED, "Loaded")

    with(FileLoader()) {
        println()
        loadFile("Test_1.kt")
        println()
        loadFile("Test_2.kt")
        println()
        loadFile("Test_3.kt")
    }
}

fun printLog(level: LogLevel, message: String) = print("\n$level: \t$message")