package src.syntax.functions.function_type.static_func.example_1;

import syntax.functions.function_type.static_func.example_1.ChatBot;
import syntax.functions.function_type.static_func.example_1.Deposit;
import syntax.functions.function_type.static_func.example_1.Person;

public class StaticFuncMain {
    public static void main(String[] args) {
        // #1
        // Call 'static method' in the companion object of the enclosing 'Person' class
        Person.callStatic();
        Person.Companion.callStatic();                  // instance method remains

        // Call 'non-static method' in the companion object of the enclosing 'Person' class
        // Person.callNonStatic();                      // error: not a static method
        Person.Companion.callNonStatic();               // the only way it works

        // Call 'non-static method' in the 'Person' class
        // Person.callNonStatic();                       // error: not a static method

        System.out.println();

        // #2
        // Call 'static method' in the object 'Deposit'
        Deposit.callStatic();
        Deposit.INSTANCE.callStatic();                  // instance method remains

        // Call 'non-static method' in the object 'Deposit'
        // Deposit.callNonStatic();                     // error: not a static method
        Deposit.INSTANCE.callNonStatic();               // works, a call through the singleton instance

        System.out.println();

        // #3
        // Call 'static method' in the companion object of the enclosing 'ChatBot' interface
        ChatBot.greet("Johny");
        ChatBot.Companion.greet("Claudio");
    }
}
