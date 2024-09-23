package syntax.operator.type.boolean_operator

/**
 * 'Logical operators':
 *
 *  Operator 	| 		Name		|		Description
 * ===============================================================================================
 * 	&&		    | 	Logical and		| Returns 'true' if both operands are true
 * 	||		    |	Logical or		| Returns 'true' if either of the operands is 'true'
 * 	!		    |	Logical not		| Reverse the result, returns 'false' if the operand is 'true'
 */
fun main() {
    var x = true
    var y = false

    println(
        "Show result of calculation:" +
        "\n\t$x && $y: ${x && y}" +
        "\n\t$x || $y: ${x || y}" +
        "\n\t!$x: ${!x}"
    )
}
