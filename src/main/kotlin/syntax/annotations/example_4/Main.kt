package syntax.annotations.example_4

import java.io.FileNotFoundException
import java.nio.file.Paths
import kotlin.jvm.Throws

class File(private val path: String) {
    fun exists(): Boolean {
        // #1 no '@Throws' annotation
        /*if (!Paths.get(path).toFile().exists()) {
            throw FileNotFoundException("path: '$path' does not exist")
        }*/

        // #2 with '@Throws' annotation
        @Throws(FileNotFoundException::class)
        if (!Paths.get(path).toFile().exists()) {
            throw FileNotFoundException("path: '$path' does not exist")
        }

        return true
    }
}
