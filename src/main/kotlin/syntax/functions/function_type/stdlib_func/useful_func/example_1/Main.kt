package syntax.functions.function_type.stdlib_func.useful_func.example_1

import kotlin.random.Random

/**
 * Stdlib function 'lazy'.
 *
 * This is a common pattern seen in many languages and frameworks.
 * The advantage of using this built-in function over rolling our own is that synchronization is
 * taken care of for us.
 */
fun main() {
    // #1
    fun readStringFromDatabase(): String = "Info from Database" // expensive operation

    // If the value is requested twice, Kotlin will safely handle any race conditions
    // by only executing the underlying function once.
    val lazyString = lazy { readStringFromDatabase() }

    // The first time we require the result, we can access the value on the "lazy" reference.
    // Only then the wrapped function actually will be invoked
    val string = lazyString.value

    println(
        "Show data received from DB: $string"
    )

    // #2
    val session = Session()
    println(
        "\nShow marks of the student_#1: ${session.mentor.getStudentMarks()}" +
        "\n\tShow mentor info: ${session.mentor}" +
        "\n\tShow marks of the student_#2: ${session.mentor.getStudentMarks()}" +
        "\n\tShow mentor info: ${session.mentor}"
    )
}

class Session {
    val mentorId = Random.nextInt(150)

    val names = listOf("Ron Paul", "James Cameron")
    val randomIndex = Random.nextInt(1)
    val randomName = names.get(randomIndex)

    // Use 'lazy' keyword to initialize 'mentor' only once and only when it is called.
    val mentor: Mentor by lazy {
        println("call mentor initialization")
        Mentor(mentorId, randomName)
    }
}

data class Mentor(
    val id: Int,
    val name: String,
) {
    val address = "Mentor Address"
    val courses = listOf("Course_1", "Course_2")
    val phone = "Mentor Phone"

    fun getStudentMarks(): Map<String, String> {
        return mapOf(
            courses.first() to "A",
            courses.last() to "B"
        )
    }

    override fun toString(): String {
        return "Mentor(id='$id', name='$name', address='$address', courses=$courses, phone='$phone')"
    }


}