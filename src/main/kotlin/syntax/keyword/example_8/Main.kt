package syntax.keyword.example_8

fun main() {
    // #1
    val container = Container()
    container.initProperty(DelayedInstance(10))
    println("with delayed initialization: Number = ${container.delayedInitProperty.number}")

    // #2
    val test = SqlTests()
    test.dbConnType = "MySql"

    // Check if property with 'lateinit' was initialized
    if (test.hasValue()) {
        println("\nConnection to: ${test.dbConnType}")
    }
}

// #1
class Container {
    // The 'lateinit' keyword is used to perform initialization later in the 'initProperty()' method
    lateinit var delayedInitProperty: DelayedInstance

    fun initProperty(instance: DelayedInstance) : Unit {
        this.delayedInitProperty = instance
    }
}
class DelayedInstance (val number: Int)

// #2
class SqlTests {
    // The 'lateinit' keyword is used to perform initialization later when instance of the class
    // will be created.
    lateinit var dbConnType: String

    fun hasValue() = this::dbConnType.isInitialized
}
