package src.syntax.annotations.example_1;

import java.util.ArrayList;
import syntax.annotations.example_1.StringFunctions;

public class AnnotationsMain {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // #1 no annotation
        // Call static method from JoinKt file (before using annotation)
        /*String joinedString = JoinKt.joinToString(
            list,
            ", ",
            "",
            ""
        );*/

        // #2 with annotation
        // Using annotation '@file: JvmName("...")' we can set virtually new file name and use it in code
        // not changing real file name.
        // To do it we have to put this annotation at the first line of the file before package name.
        // Notice:
        // String joinedString = StringFunctions.joinToString(list,", ","", "");

        // #3
        // To call Kotlin function from Java, having arguments with default values, we have to specify
        // values for all the arguments.
        // To avoid this we can put annotation '@JVMOverloads' before required method
        String joinedString = StringFunctions.joinToString(list);

        // print ArrayList
        System.out.println("ArrayList : " + list + "\njoinedString: " +joinedString);
    }
}
