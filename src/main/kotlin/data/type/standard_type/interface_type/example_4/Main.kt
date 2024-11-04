package data.type.standard_type.interface_type.example_4

import java.util.logging.Logger

fun main() {
    // #1
    with(LoggingExecutableImpl()) {
        beforeExecute()
        execute()
        afterExecute()
    }

    // #2
    with(Car("Tesla", "2345SDG")) {
        move()
    }
}

interface Executable {
    fun afterExecute() {}
    fun beforeExecute() {}
    fun execute(): Int
}

// Every implementor will get a real logger in the 'log' field.
interface Loggable {
    val log: Logger
        get() = Logger.getLogger(javaClass.name)
}

interface LoggingExecutable : Executable, Loggable {
    override fun beforeExecute() {
        log.info("Before executing: $this")
    }

    override fun afterExecute() {
        log.info("After executing: $this")
    }
}

class LoggingExecutableImpl : LoggingExecutable {
    override fun execute(): Int {
        log.info("Executing: $this")
        return 0
    }
}

interface Movable {
    val speed: Int
    val model: String
    val number: String

    fun move()
}

class Car(override val model: String, override val number: String) : Movable {
    override var speed = 60

    override fun move() {
        println("Driving a car '$model: $number' with speed $speed mi/h")
    }
}
