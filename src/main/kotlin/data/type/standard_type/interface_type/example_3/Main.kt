package data.type.standard_type.interface_type.example_3

fun main() {
    // #1
    println(
        "Show user nickname:" +
        "\n\tof 'PrivateUser': ${PrivateUser("private_user").nickName}" +
        "\n\tof 'SubscribeUser': ${SubscribeUser("subscribe_user@gmaail.com").nickName}" +
        "\n\tof 'SubscribeUserExt': ${SubscribeUserExt("subscribe_user@gmaail.com").nickName}" +
        "\n\tof 'FacebookUser': ${FacebookUser(12345).nickName}"
    )

    println()

    // #2
    with(Car()) {
        move()
    }
    with(Aircraft()) {
        move()
    }
}

// Interface doesn't hold property value
interface User {
    val nickName: String
}

interface UserExt {
    val email: String

    val nickName: String
        get() = email.substringBefore('@')
}

class PrivateUser(override val nickName: String) : User

class SubscribeUser(val email: String) : User {
    override val nickName: String
        get() = "${email.substringBefore('@')} (email: $email)"
}

class SubscribeUserExt(override val email: String) : UserExt

class FacebookUser(val accountId: Int) : User {
    override val nickName: String = getFaceBookName(accountId)

    fun getFaceBookName(accountId: Int) = "facebook_user (accountId: $accountId)"
}

interface Movable {
    var speed: Int
    fun move()
}

class Car : Movable {
    override var speed = 60
    override fun move() {
        println("Driving a car with speed: $speed mi/h")
    }
}

class Aircraft : Movable {
    override var speed = 600
    override fun move() {
        println("Flying with aircraft with speed: $speed mi/h")
    }
}
