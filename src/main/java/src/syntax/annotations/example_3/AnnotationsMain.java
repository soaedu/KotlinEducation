package src.syntax.annotations.example_3;

import syntax.annotations.example_3.SampleObject;

public class AnnotationsMain {
    public static void main(String[] args) {
        // #1 no '@JvmStatic' annotation
        /*System.out.println(
                "counter = " + SampleObject.INSTANCE.getCounter()
        );

        SampleObject.INSTANCE.showText("Hello!");*/


        // #2 with '@JvmStatic' annotation
        System.out.println(
                "counter = " + SampleObject.getCounter()
        );

        SampleObject.showText("Hello!");
    }
}
