package src.data.type.standard_type.collection_type.type.list_type.example_2;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public class CollectionUtils {
    public static void addItem(@NotNull List<Integer> list) {
        list.add(1000);
    }

    public static List<String> uppercaseAll(@NotNull List<String> items) {
        for (int i=0; i < items.size(); i++) {
            items.set(i, items.get(i).toUpperCase());
        }
        return items;
    }
}
