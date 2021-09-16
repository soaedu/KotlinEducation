package syntax.functions.type.inline_func.scope_func.take_unless

import syntax.functions.type.inline_func.scope_func.take_if.Issue

/**
 * takeUnless() -   returns the receiver object if it doesn't satisfy
 *                  the given predicate, otherwise returns "null"
 */
fun main() {
    val issueList = listOf(
        Issue("issue1", syntax.functions.type.inline_func.scope_func.take_if.State.FIXED),
        Issue("issue2", syntax.functions.type.inline_func.scope_func.take_if.State.OPEN),
        Issue("", syntax.functions.type.inline_func.scope_func.take_if.State.FIXED),
        Issue("issue4", syntax.functions.type.inline_func.scope_func.take_if.State.OPEN)
    )

    issueList.forEach { issue ->
        println("\titem: ${issue.msg.takeUnless(String::isNotEmpty)}")
    }
}

enum class State {
    FIXED, OPEN
}

data class Issue(val msg: String, val status: State)