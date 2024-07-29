package syntax.annotations.example_3

object SampleObject {
    // #1 no '@JvmStatic' annotation
    /*var counter: Int = 0
        get() = 10
        set(value) {
            field = value
        }

    fun showText(text: String) = println(text)*/

    // #2 with '@JvmStatic' annotation
    @JvmStatic
    var counter: Int = 0
        get() = 10
        set(value) {
            field = value
        }

    @JvmStatic
    fun showText(text: String) = println(text)
}