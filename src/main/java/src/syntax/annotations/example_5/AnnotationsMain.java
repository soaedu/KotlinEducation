package src.syntax.annotations.example_5;

import syntax.annotations.example_5.MainKt;
import syntax.annotations.example_5.MyClass;
import syntax.annotations.example_5.MyObject;
import syntax.annotations.example_5.MyWrapper;

public class AnnotationsMain {
    public static void main(String[] args) {
        // #1 @JvmField on the property outside the class
        MyClass link_1 = MainKt.prop_1;
        System.out.println(
                "Class name: " + link_1.getClass().getName()
        );

        // #2 @JvmField on the property inside the object
        MyClass link_2 = MyObject.prop_2;
        System.out.println(
                "Class name: " + link_2.getClass().getName()
        );

        // #3 @JvmField on the property inside the class
        MyClass link_3 = new MyWrapper().prop_3;
        System.out.println(
                "Class name: " + link_3.getClass().getName()
        );
    }
}
