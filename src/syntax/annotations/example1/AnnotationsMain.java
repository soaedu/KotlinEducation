package syntax.annotations.example1;

// import syntax.annotations.example1.strings.JoinKt;
import syntax.annotations.example1.strings.*;

import java.util.ArrayList;

public class AnnotationsMain {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        // #1
        // Вызов статического метода из класса JoinKt (до использования аннотации)
        // String joinedString = JoinKt.joinToString(list ,", ","", "");

        // #2
        // Изменение имени класса в файпе.
        // Чтобы изменить имя класса с КоtLin-функциями верхнего уровня, нужно добавить в
        // файл аннотацию @JvmName.
        // Поместите её в начало файла перед именем пакета:
        // @file: JvmName("StringFunctions")                <- Аннотация дnя объямения имени класса
        // package strings                                  <- Выражение package следует за аннотациями уровня файла
        // fun joinToString( . . . ): String { ... }
        // Теперь функцию можно вызвать так:
        /* Java */
        // import strings.StringFunctions;
        // StringFunctions.joinToString(list ,", ","", "");
        String joinedString = StringFunctions.joinToString(list ,", ","", "");

        // print ArrayList
        System.out.println("ArrayList : " + list + "\njoinedString: " +joinedString);
    }
}
