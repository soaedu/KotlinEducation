package src.syntax.annotations.example_7;

//import syntax.annotations.example_7.MainKt;

public class AnnotationsMain {
    public static void main(String[] args) {
        // #1 inline function without annotation
        // int result = MainKt.run({x: Int -> x * 2 })  // Can call inline function

        // #2 inline function with annotation '@InlineOnly'
        // int result = MainKt.run({x: Int -> x *2 })  // Can't be called inline function because it has private access
    }
}
