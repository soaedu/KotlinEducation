package src.syntax.annotations.example_6;

// import syntax.annotations.example_6.SuperComputer;

import syntax.annotations.example_6.MainKt;

public class AnnotationsMain {
    public static void main(String[] args) {

        /*
         * Object property
         */
        // #1 property inside the object without annotation
        // int answer = SuperComputer.INSTANCE.getAnswer();

        // #2 property inside the object with annotation '@JvmStatic'
        // int answer = SuperComputer.getAnswer();

        // #3 property inside the object with annotation '@JvmField'
        // int answer = SuperComputer.answer;

        // #4 property inside the object without annotation but with
        // 'const' keyword.
        // int answer = SuperComputer.answer;


        /*
         * Top level property
         */
        // #5 top level property without annotations
        // int answer = MainKt.getAnswer();

        // #6 top level property with annotation '@JvmField'
        // int answer = MainKt.answer;

        // #7 top level property without annotations but with
        // 'const' keyword.
        int answer = MainKt.answer;     // Value can be changed.
        answer = 19;

        System.out.println(
                "answer: " +answer
        );
    }
}
