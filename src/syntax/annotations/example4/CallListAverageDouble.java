package syntax.annotations.example4;

import java.util.ArrayList;
import java.util.List;

public class CallListAverageDouble {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        System.out.println("1. average of ints: " +AnnotationsMainKt.average(intList));

        List<Double> doubleList = new ArrayList<Double>();
        doubleList.add(1.0);
        doubleList.add(2.0);
        doubleList.add(3.0);
        doubleList.add(4.0);
        System.out.println("2. average of doubles: " +AnnotationsMainKt.averageOfDouble(doubleList));
    }
}
