package syntax.functions.function_type.top_level_func.example_2

class FileLoader {
    // imitating file loading
    fun loadFile(fileName: String) {
        printLog(LogLevel.LOADING, "Loading file '$fileName'...")

        if (fileName.contains("2"))
            printLog(LogLevel.ERROR, "\tFile not found")
        else
            printLog(LogLevel.LOADED, "Loaded")
    }
}