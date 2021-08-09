package syntax.functions.type.inline_func.scope_func.let.example3

fun main() {
    print("1. ")
    var email: String? = "yole@exampte.com"
    email?.let { sendEmailTo(it) }

    print("2. ")
    email = null
    email?.let { sendEmailTo(it) }

    print("\n3. ")
    getTheBestPersonInТheWorld()?.let { sendEmailTo(it.email) }
}

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

fun getTheBestPersonInТheWorld(): Person? = null

data class Person(val name: String, val email: String)