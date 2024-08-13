package src.syntax.functions.function_type.extension_func.example_4;

import static syntax.functions.function_type.extension_func.example_4.StringExtensionKt.lastChar;

public class ExtensionFuncMain {
    public static void main(String[] args) {
        String str = "Java";

        // Call the kotlin 'extension' function from Java.
        // System.out.println("Last character of the " +str+ " is: " +StringExtensionKt.lastChar(str));
        System.out.println("Last character of the " +str+ " is: " +lastChar(str));
    }
}
