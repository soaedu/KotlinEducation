package syntax.functions.type.lambda_func.example14

fun main() {

    // Если нужно вызвать функцию без аргументов или с одним аргументом, то подходит такой вариант
    val action1 = ::sendMail1

    // Если нужно вызвать функцию с несколькими аргументами, то лучше использовать такой вызов
    val action2 = { address: String, message: String -> sendMail2(address, message) }

    print("1. ")
    action1.invoke()

    print("2. ")
    run { action2("test@mail.ru", "Hello Bro!") }
}

fun sendMail1() = println("Sending email..")

fun sendMail2(address: String, message: String) = println("Sending email on $address")