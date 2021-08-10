package data.type.unit.example1

fun main() {
    NoResultProcessor().process()
}

interface Processor<T> {
    fun process(): T
}

class NoResultProcessor : Processor<Unit> {
    // Возвращает значение типа Unit, но в объявлении это не указано
    override fun process() {
        print("Hello")
    }

    // Не требуется писать инструкцию "return Unit", т.к. ее неявно добавляет компилятор
}