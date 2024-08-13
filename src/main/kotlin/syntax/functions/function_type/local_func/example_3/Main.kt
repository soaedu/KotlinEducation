package syntax.functions.function_type.local_func.example_3

import java.lang.IllegalStateException

fun main() {
    val user = User("1", "Test Name", "Test Address")
    saveUser(user)
}

class User(val id: String, val name: String, val address: String)

// #1
// Check fields duplication is used.
/*
fun saveUser(user: User) {
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

    // Save user information into DB
    // ...
}*/


// #2
// Use 'local function' inside 'outer function' to validate arbitrary field.
/*fun saveUser(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalStateException(
                "Can't save user ${user.id}: empty $fieldName"
            )
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")

    // Save user information into DB
    // ...
}*/

// #3
// Moving logic with field(s) validation to the 'extension function' of the 'User' class.
fun saveUser(user: User) {
    user.validateBeforeSave()

    // Save user information into DB
    // ...
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

