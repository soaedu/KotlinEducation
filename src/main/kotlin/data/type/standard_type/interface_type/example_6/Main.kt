package data.type.standard_type.interface_type.example_6

fun main() {
    // #1
    with(MediaPlayer()) {
        play()
    }

    println()

    // #2
    with(Button()) {
        showOff()
        setFocus(true)
        click()
    }
}

interface AudioPlayable {
    fun play() = println("Play audio")
}
interface VideoPlayable {
    fun play() = println("Play video")
}

class MediaPlayer : AudioPlayable, VideoPlayable {
    // Use one method for both interfaces
    override fun play() {
        println("Start playing...")
        super<AudioPlayable>.play()
        super<VideoPlayable>.play()
    }
}

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable")
}

interface Focusable {
    fun setFocus(value: Boolean) = println("I've ${if (value) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable")
}

class Button : Clickable, Focusable {
    override fun click() = println("I was clicked")

    override fun showOff() {
        // Use one method for both interfaces
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}
