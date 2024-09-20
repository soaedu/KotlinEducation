package src.syntax.functions.function_type.static_func.example_2;

import syntax.functions.function_type.static_func.example_2.MainKt;

public class StaticFuncMain {
    public static void main(String[] args) {
        String word = "Hello";

        // Call 'static method' defined as 'package-level' function.
        System.out.println(
            "Show the first letter of the " +word+ ": " +MainKt.showFirstCharacter(word)
        );
    }
}
