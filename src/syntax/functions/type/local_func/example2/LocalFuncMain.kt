package syntax.functions.type.local_func.example2

import java.lang.IllegalStateException

fun main() {
    val user = User("1", "Test Name", "Test Address")
    saveUser_1(user)
    saveUser_2(user)
    saveUser_3(user)
}

class User(val id: String, val name: String, val address: String)

// #1 Обычное решение с дублирование проверки полей
fun saveUser_1(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalStateException(
                "Can't save user ${user.id}: empty name"
        )
    }

    if (user.address.isEmpty()) {
        throw IllegalStateException(
                "Can't save user ${user.id}: empty address"
        )
    }

    // Сохранение информации о пользователе в базе данных
}

// #2 Улучшенное решение, с:
//  * Объявлением локальной функции для проверки произвольного поля
//  * Вызовов функции для проверки конкретных полей
fun saveUser_2(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalStateException(
                    "Can't save user ${user.id}: empty $fieldName"
            )
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")

    // Сохранение информации о пользователе в базе данных
}

// #3 Наилучшее решение, с переносом логики проверки в функцию-расширения класса User.
fun saveUser_3(user: User) {
    user.validateBeforeSave()

    // Сохранение информации о пользователе в базе данных
}
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalStateException(
                "Can't save user $id: empty $fieldName"
            )
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

