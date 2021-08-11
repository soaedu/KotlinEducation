package data.type.collections.example4;

import java.util.List;

/**
 * Переданная из Kotlin, неизменяемая коллекция, может быть изменена в Java.
 */
public class CollectionUtils {
    public static List<String> uppercaseAll(List<String> items) {
        for (int i=0; i< items.size(); i++) {
            items.set(i, items.get(i).toUpperCase());
        }
        return items;
    }
}
