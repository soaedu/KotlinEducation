package src.data.type.standard_type.collection_type.type.array_type.example_1;

import static data.helpers.PrintDataKt.printItems;

public class ArrayMain {
    public static void main(String[] args) {
        final String[] strings = {"only", "strings", "here"};

        // error: ArrayStoreException
        // final Object[] mix = oops;
        // mix[1] = 42;

        printItems("Show items of 'strings' array", strings);
    }
}
