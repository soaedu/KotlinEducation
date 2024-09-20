package syntax.functions.function_type.stdlib_func.example_1.scope_func.example_1

import src.syntax.functions.function_type.scope_func.example_1.User
import src.syntax.functions.function_type.scope_func.example_1.UserBuilder

/**
 * Scope function 'apply' has definition in the 'standard library' like this
 *
 * public inline fun <T> T.apply(block: T.() -> Unit): T {
 *     block()
 *     return this
 * }
 *
 * accepts a lambda that is invoked with the receiver being the instance (where 'apply' was called on)
 * represents the 'context object' as the 'implicit receiver'
 * returns the 'context object' (receiver)
 *
 * Should be used if we:
 *     * need to initialize an instance more readable
 *     * are not accessing any function(s) of the 'receiver' within our 'block'
 *     * want to return the same 'receiver'
 */
fun main() {
    val noInitialization = {userBuilder: UserBuilder -> userBuilder}
    val initUserLambda = { userBuilder: UserBuilder ->
        userBuilder(userBuilder).apply {
            setName("User_2")
            setAddress("Address_2")
            setEmail("user_2@gmail.ru")
        }
    }
    println(
        "Show info of the user with: " +
        "\n\tno id: ${getUserById("")?.build()}" +
        "\n\tid = 1: ${getUserById("1")?.build()}" +
        "\n\t----------------------------------------------------------------------------------" +
        "\n\tno initialization: ${getUser(noInitialization)}"+
        "\n\tid = 2: ${getUser(initUserLambda)}"
    )
}

// #1
// Use 'scope function' to define values in the receiver.
fun getUserById(id: String): UserBuilder? =
    when {
        id.isEmpty() -> null
        else -> UserBuilder().apply {
            setName("User_1")
            setAddress("Address_1")
            setEmail("user_1@gmail.com")
        }
    }

// #2
// Use functional type to define values
fun getUser(init: (userBuilder: UserBuilder) -> UserBuilder): User {
    return UserBuilder().apply {
        init(this)
    }.build()
}

private fun userBuilder(userBuilder: UserBuilder) = userBuilder
