package syntax.functions.type.inline_func.example4

import java.io.BufferedReader
import java.io.FileReader

/* Java */
/*static String readFirstLineFromFile(String path) throws IOException {
    try ( BufferedReader br =
            new BufferedReader(new FileReader(path) ) ) {
        return br . readLine( ) ;
    }
}*/

fun main() {
    val filePath = "/home/ss/HOME/EDUCATION/1_Computer_Disciplines/6_Programming/1_Languages/2_Kotlin/" +
            "2_Code/KotlinEducation/src/syntax/functions/type/inline_func/example4/LazyFuncMain.kt"
    println("\nFirst line: ${readFirstLineFromFile(filePath)}")
}

fun readFirstLineFromFile(path: String): String {
    BufferedReader(FileReader(path)).use { br ->        // Создается зкземппяр BufferedReader,
                                                        // вызывается функция «use», и ей передается лямбда-выражение,
                                                        // выполняющее операцию с файлом
        return br.readLine()                            // Возвращается строка, прочитанная из файла
    }
}
