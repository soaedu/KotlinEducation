package syntax.functions.type.inline_func.example1

import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock

/**
 * Как работает встраивание функций
 *
 * Когда функция объявляется с модификатором inline, её тело становится встраиваемым - иными словами, оно подставляется
 * вместо обычного вызова функции.
 */
fun main() {
    val l = object: Lock {
        override fun lock() {}

        override fun lockInterruptibly() {}

        override fun tryLock(): Boolean {
            return true
        }

        override fun tryLock(time: Long, unit: TimeUnit): Boolean {
            return true
        }

        override fun unlock() {}

        override fun newCondition(): Condition {
            TODO("Not yet implemented")
        }
    }
    synchronized(l) {
        // ...
    }
}

/**
 * Определение встраиваемой функции
 */
inline fun <Т> synchronized(lock: Lock, action: () -> Т): Т {
    lock.lock()

    try {
        return action()
    } finally {
        lock.unlock()
    }
}

/**
 * Так как мы объявили функцию synchronized встроенной (inline), её тело будет вставлено в каждом месте вызова,
 * подобно инструкции synchronized в Java.
 *
 * Встраивание применяется не только к реализации функции synchronized, но и к телу лямбда-выражения.
 * Байт-код, сгенерированный для лямбда-выражения, становится частью определения вызывающей функции и не заключается в
 * анонимный класс, реализующий интерфейс функции.
 */
fun foo(l: Lock) {
    println("Before sync")
    synchronized(l) {
        println("Action")
    }
    println("After sync")
}
// Эквивалентный код, который будет скомпилирован в тот же байт-код.
/*fun foo(l: Lock) {
    println("Before sync")              // Код функции foo
    l.lock()                            // Код, вараиваемый в место вызова функции synchronized
    try {                               // Код, вараиваемый в место вызова функции synchronized
        println("Action")               // Встраиваемый код с телом лямбда-выражения
    } finally {                         // Код, вараиваемый в место вызова функции synchronized
        l.unlock()                      // Код, вараиваемый в место вызова функции synchronized
    }                                   // Код, вараиваемый в место вызова функции synchronized
    println("After sync")               // Код функции foo
}*/

/**
 * Для встраиваемых функций сохранилась возможность передавать параметры с типом функции из переменных.
 */
class LockOwner(val lock: Lock) {
    fun runUnderLock(body: () -> Unit) {
        synchronized(lock, body)        // Переменная с типом функции передается как аргумент, но не как лямбда-выражение
    }
}
// В данном случае код лямбда-выражения недоступен в точке вызова функции, поэтому его нельзя встроить.
// Встроится только тело функции synchronized, а лямбда-выражение будет вызвано как обычно. Функция runUnderLock будет
// скомпилирована в байт-код, который выглядит так:
/*class LockOwner(val lock: Lock) {
    fun __runUnderLock__(body: () -> Unit) {    // Эrа функция компилируется в такой же байт-код, что и настоящая
                                                // функция runUnderLock()
        lock.lock()
        try {
            body()                              // Функция body не встраивается, потому что лямбда·выражение
                                                // отсутствует в точке вызова
        } finally {
            lock.unlock()
        }
    }
}*/
// Если использовать встраиваемую функцию в двух разных местах с разными лямбда-выражениями, каждый вызов встроится
// независимо. Код встраиваемой функции скопируется в оба места, но с разными лямбда-выражениями.
