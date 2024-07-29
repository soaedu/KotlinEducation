package src.syntax.annotations.example_2;

import syntax.annotations.example_2.MainKt;

import java.util.ArrayList;
import java.util.List;

public class AnnotationsMain {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("BC");
        strings.add("DEF");
        strings.add("GHIJ");

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(3);
        ints.add(5);
        ints.add(7);

        System.out.println(
                "filter strings result: " + MainKt.filterStrings(strings)+
                "\n" +
                "filter ints result: " + MainKt.filterIntegers(ints)
        );
    }
}
