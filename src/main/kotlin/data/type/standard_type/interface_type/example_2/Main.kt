package data.type.standard_type.interface_type.example_2

fun main() {
    // #1
    val humanImpl = HumanImpl()
    println(humanImpl)
    with(humanImpl) {
        greet()
        greetFromMale()
        greetFromFemale()
    }

    println()

    // #2
    val tom = WorkingStudent("Tom")
    study(tom)
    work(tom)
}

interface Human {
    val age: Int        // abstract property
    fun greet()         // abstract method
}

interface Male : Human {
    fun greetFromMale() {
        println("Greet from a male")
    }
}

interface Female : Human {
    fun greetFromFemale() {
        println("Greet from a female")
    }
}

// Apply inheriting multiple interfaces.
class HumanImpl : Human, Male, Female {
    override val age: Int
        get() = 25

    override fun greet() {
        println("Greet from 'HumanImpl'")
    }

    override fun toString(): String {
        return "HumanImpl(age = $age)"
    }
}

interface Worker {
    fun work()
}

interface Student {
    fun study()
}

class WorkingStudent(val name: String) : Worker, Student {
    override fun work() {
        println("Student $name works")
    }

    override fun study() {
        println("Student $name studies")
    }
}

fun work(worker: Worker) = worker.work()
fun study(student: Student) = student.study()