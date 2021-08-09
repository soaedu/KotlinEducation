package syntax.functions.type.inline_func.example1

fun main() {
    val myLambda: (String) -> Unit = {s: String -> print(s)}
    val value = " TutorialsPoint.com"
    myFunc(value, myLambda)     // passing lambda as a parameter of another function
}

fun myFunc(str: String, action: (String) -> Unit) {     // passing lambda
    print("\nHeyyy!!!")
    action(str)         // call to lambda function
}