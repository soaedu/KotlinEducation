package data.type.sequence

public interface Sequence<out T> {
    public operator fun iterator(): Iterator<T>
}

// public fun <T: Any> generateSequence(nextFunction: () -> T?): Sequence<T> = ...

// public fun <T: Any> generateSequence(seed: T?, nextFunction: (T) -> T?): Sequence<T> = ...