package syntax.functions.type.inline_func.scope_func.take_if

/**
 * takeIf() -   returns the receiver object if it satisfies
 *              the given predicate, otherwise returns "null"
 */
fun main() {
    val issueList = listOf(
        Issue("issue1", State.FIXED),
        Issue("issue2", State.OPEN),
        Issue("", State.FIXED),
        Issue("issue4", State.OPEN)
    )

    println("1. ")
    issueList.forEach { issue ->
        println("\titem: ${issue.takeIf { it.status == State.FIXED }} ")
    }

    println("2. ")
    issueList.forEach { issue ->
        println("\titem: ${issue.msg.takeIf(String::isNotEmpty)} ")
    }

    print("3. ")
    issueList.filter { it.status == State.OPEN }
        .takeIf(List<Issue>::isNotEmpty)
        ?.let { println("There are some open issues") }
}

enum class State {
    FIXED, OPEN
}

data class Issue(val msg: String, val status: State)

