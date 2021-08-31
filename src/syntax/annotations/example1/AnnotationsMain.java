package syntax.annotations.example1;

import syntax.annotations.example1.strings.*;
import java.util.ArrayList;

public class AnnotationsMain {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        // #1 no annotation
        // Вызов статического метода из класса JoinKt (до использования аннотации)
        // String joinedString = JoinKt.joinToString(list ,", ","", "");

        // #2 with annotation
        // Изменение имени класса в файпе.
        // Чтобы изменить имя класса с КоtLin-функциями верхнего уровня, нужно добавить в
        // файл аннотацию @JvmName.
        // Поместите её в начало файла перед именем пакета:
        // String joinedString = StringFunctions.joinToString(list,", ","", "");

        // #3
        // Чтобы вызвать из Java функцию, написанную на Kotlin и имеющую аргументы с значениями по-умолчанию,
        // нужно указать значения для всех аргументов.
        // String joinedString = StringFunctions.joinToString(list,", ","", "");

        // #4
        // Чтобы вызвать из Java функцию, написанную на Kotlin и имеющую аргументы с значениями по-умолчанию,
        // и не указывать значения для всех этих аргументов, метод нужно предварить аннотацией @JVMOverloads
        String joinedString = StringFunctions.joinToString(list);

        // print ArrayList
        System.out.println("ArrayList : " + list + "\njoinedString: " +joinedString);
    }
}
