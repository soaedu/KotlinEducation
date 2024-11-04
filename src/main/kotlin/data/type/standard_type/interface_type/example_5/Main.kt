package data.type.standard_type.interface_type.example_5

fun main() {
    // #1
    with(MediaPlayer()) {
        play()
    }

    println()

    // #2
    with(Car()) {
        move()
        stop()
    }
    with(Aircraft()) {
        move()
        stop()
    }
}

interface AudioPlayable {
    fun play()
}

interface VideoPlayable {
    fun play()
}

class MediaPlayer : AudioPlayable, VideoPlayable {
    // Method 'play' for both interfaces
    override fun play() {
        println("Play audio and video")
    }
}

interface Movable {
    fun move()
    fun stop() {
        println("Stopping...")
    }
}

class Car : Movable {
    override fun move() {
        println("Driving a car")
    }

    // use parent realisation of the 'stop' method
}

class Aircraft : Movable {
    override fun move() {
        println("Flying on the aircraft")
    }

    // override parent realisation of the 'stop' method
    override fun stop() {
        println("Landing...")
    }
}
