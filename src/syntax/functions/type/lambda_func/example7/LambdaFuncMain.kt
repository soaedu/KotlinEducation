package syntax.functions.type.lambda_func.example7

/**
 * Доступ к переменным из контекста
 */
fun main() {
    val errors = listOf("403 Forbidden", "404 Not Found")
    println("1. Print message with prefix:")
    printMessageWithPrefix(errors, "Error:")

    val responses = listOf("200 ОК", "418 I'm а teapot", "500 Internal Server Error")
    println("2. Print problem counts:")
    printProblemCounts(responses)
}

/**
 * Функция принимает список сообщений и выводит каждое с заданным префиксом.
 */
fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("\t$prefix $it")
    }
}


/**
 * Одно важное отличие Kotlin от Java состоит в том, что Kotlin не ограичивается доступом только к финальным переменным.
 * Вы можете изменять переменные внутри лямбда-выражений. Следующий листинг подсчитывает количество клиентских и
 * серверных ошибок в данном наборе кодов ответа.
 */
fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0

    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if(it.startsWith("5")) {
            serverErrors++
        }
    }

    println("\t$clientErrors client errors, $serverErrors server errors")
}