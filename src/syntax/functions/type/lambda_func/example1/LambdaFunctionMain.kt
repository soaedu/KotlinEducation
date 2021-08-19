package syntax.functions.type.lambda_func.example1

fun main() {
    val myLambda: (String) -> Unit = { s: String -> print(s) }
    val value = "TutorialsPoint.com"
    print("1. ")
    myLambda(value)

    print("\n2. ")
    myFunc(value, myLambda)                             // passing lambda as a parameter of another function
}

fun myFunc(str: String, action: (String) -> Unit) {     // passing lambda
    print("Heyyy!!! ")
    action(str)                                         // call to lambda function
}