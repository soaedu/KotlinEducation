package syntax.functions.operation.overriding.example_1

import java.io.ByteArrayOutputStream
import java.io.OutputStream

/**
 * Operation 'overriding' helps us to redefine one of the methods inherited from one
 * of the parent classes or interfaces in our new class.
 */
fun main() {
    val os = ByteArrayOutputStream()
    val pngImage = PNGImage()
    pngImage.save(os)

    println()
}

open class Image {
    open fun save(output: OutputStream) {
        println("Some logic to save an image")
    }
}
interface VendorImage {
    fun save(output: OutputStream) {
        println("Vendor saving an image")
    }
}
class PNGImage: Image(), VendorImage {
    override fun save(output: OutputStream) {
        // Referencing the parent implementation is done via 'super<PARENT>'
        super<VendorImage>.save(output)
        super<Image>.save(output)
    }
}
