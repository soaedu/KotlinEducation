package src.syntax.functions.operation.example_1;

/**
 * Operation 'overloading' represents definition of few functions with the identical name
 * but with different parameters.
 */
public class OverloadMethodMain {
    public static void main(String[] args) {
        System.out.println(
            "call method #1: " + printString("test") +
            "\ncall method #2: " + printString("test", 25) +
            "\ncall method #3: " + printString("test", true) +
            "\ncall method #4: " + printString("test", 33, true)
        );
    }

    // Five Java methods can be represented by one in Kotlin

    // #1
    public static String printString(String name) {
        return printString(name, 42);
    }

    // #2
    public static String printString(String name, int number) {
        return printString(name, number, false);
    }

    // #3
    public static String printString(String name, boolean toUpperCase) {
        return printString(name, 42, toUpperCase);
    }

    // #4
    public static String printString(String name, int number, boolean toUpperCase) {
        return (toUpperCase ? name.toUpperCase() : name) + number;
    }
}
