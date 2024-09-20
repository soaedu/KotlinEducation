package syntax.functions.function_type.extension_func.example_6

fun main() {
    println()
    val selenium = Element("Selenium")
    selenium.react(Particle())
    selenium.react(Electron())

    println()
    val neon = NobleGas("Neon")
    neon.react(Particle())
    neon.react(Electron())
}

open class Element(val name: String) {
    // All the time this function will be called.
    open fun Particle.react(name: String): Unit {
        println("$name is reacting with a particle")
    }

    open fun Electron.react(name: String): Unit {
        println("$name is reacting with an electron to make an isotope")
    }

    // The member function is defined that accepts only type of the 'Particle' class.
    // It doesn't matter which type of 'Particle'/'Electron' we pass to it.
    // The 'receiver type' is statically determined by 'compile type' and not by the 'runtime type'. The 'react()' entry
    // Function was defined to accept a particle, so this is the type that was used to bind the
    // 'extension function'.
    fun react(particle: Particle): Unit {
        particle.react(name)
    }

    /*fun react(particle: Electron): Unit {
        particle.react(name)
    }*/
}

class NobleGas(name: String) : Element(name) {
    override fun Particle.react(name: String): Unit {
        println("$name is noble, it doesn't react with particles")
    }
    override fun Electron.react(name: String): Unit {
        println("$name is noble, it doesn't react with electrons")
    }

    // The member function is defined that accepts the subtype of the 'Particle' class.
    // Compiler can pick the function that is more specific match.
    fun react(particle: Electron): Unit {
        particle.react(name)
    }
}

open class Particle() { }

class Electron(): Particle() { }
