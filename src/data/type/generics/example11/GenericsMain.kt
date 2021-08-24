package data.type.generics.example11

import kotlin.reflect.KClass

fun main() {
    Validators.registerValidator(String::class, DefaultStringValidator)
    Validators.registerValidator(Int::class, DefaultIntValidator)

    println(Validators[String::class].validate("Kotlin"))
    println(Validators[Int::class].validate(42))

    // println(Validators[String::class].validate(42))          // Компилятор сообщит об ошибке:
                                                                //   Kotlin: The integer literal does not conform to
                                                                //   the expected type String
}

// Интерфейсы для создания валидаторов ввода
interface FieldValidator<in T> {                                // Интерфейс объявпен контравариантным по Т
    fun validate(input: T): Boolean                             // Т используется только в позиции «in» (этот метод
                                                                // потребляет значение типа Т)
}
object DefaultStringValidator: FieldValidator<String> {
    override fun validate(input: String) = input.isNotEmpty()
}
object DefaultIntValidator: FieldValidator<Int> {
    override fun validate(input: Int) = input >= 0
}

// Инкапсуляция доступа к коллекции валидаторов
object Validators {
    private val validators =
        mutableMapOf<KClass<*>, FieldValidator<*>>()

    fun <T: Any> registerValidator(kClass: KClass<T>, fieldValidator: FieldValidator<T>) {
        validators[kClass] = fieldValidator                 // Добавляет в словарь только правильную пару ключ/значение,
                                                            // когда валидатор соответствует классу
    }

    @Suppress("UNCHECKED CAST")                     // Подавляет вывод предупреждения о неконтролируемом приведении к типу FieldValidator<T>
    operator fun <T: Any> get(kClass: KClass<T>): FieldValidator<T> =
        validators[kClass] as? FieldValidator<T>
            ?: throw IllegalArgumentException("No validator for ${kClass.simpleName}")
}