package data.type.generics.example9

/**
 * Поддержка модификаторов вариантности в объявлениях классов - это очень удобно, потому что указанные модификаторы
 * применяются везде, где используется класс. Это называют "определением вариантности в месте обоявления".
 *
 * Java обрабатывает вариантность иначе. Всякий раз, когда используется тип с параметром типа, есть возможность указать,
 * что в параметре типа можно передавать подтипы или супертипы. Это называется "определением вариантности в месте
 * использования":
 *  * ? extends
 *  * ? super
 *
 *  Kotlin тоже поддерживает возможность "определения вариантности в месте использования", позволяя указывать
 *  вариантность для конкретного вхождения типового параметра, даже если он не был объявлен в классе как ковариантный
 *  или контравариантный.
 *
 *  Определение вариантности в месте использования в языке Kotlin прямо соответствует ограниченным метасимволам в Java.
 *  Объявление
 *      MutableList<out Т> в Kotlin означает то же самое, что MutableList<? extends Т> в Java
 *      входящая проекция MutableList<in Т> соответствует MutableList<? super Т>
 */
fun main() {
    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()
    copyData(ints, anyItems)

    println(anyItems)                   // Этот вызов допустим, потому что Int является подтипом Аny

    // Мы можем добавить модификатор вариантности в место использования типового параметра в объявлении, в тип:
    //  * параметра,
    //  * локальной переменной,
    //  * возвращаемого значения
    // и так далее.
    // Такое определение называется проекцией типа (type projection): оно говорит, что source это не обычный список
    // MutableList, а его проекция (с ограниченными возможностями).
    // В данном случае допускается только вызов методов, возвращающих обобщенный параметр типа (или, строго говоря,
    // использующих его только в исходящей (out) позиции).
    // Компилятор отвергнет вызовы методов, в которых данный типовой параметр используется как аргумент
    // (во входящей "in" позиции)
    /*val list: MutableList<out Number> = ...
    list.add(42)*/                              // Error: Out-projected type 'MutableList<out Number>'
                                                // prohibits the use of 'fun add(element: Е): Boolean'
}

/* Java */
/* public interface Stream<T> {
    <R> Stream<R> map(Function<? super Т, ? extends R> mapper);
}*/

// Функция копирования данных с инвариантными типовыми параметрами
// Обе коллекции имеют инвариантный тип:
//      исходная коллекция (source)        - используется только для чтения
//      коллекция назначения (destination) - используется только для записи.
// Для такой операции типы элементов коллекций могут не совпадать.
// Например, вполне корректно копировать коллекцию строк в коллекцию объектов Any.
// #1
/*fun <T> copyData( source: MutableList<T>,
                  destination: MutableList<T>
                ) {
    for (item in source) {
        destination.add(item)
    }
}*/

// Изменим функцию, чтобы она работала со списками разных типов: введем второй параметр обобщенного типа.
// #2
/*fun <T: R, R> copyData( source: MutableList<T>,
                        destination: MutableList<R>
                      ) {
    for (item in source) {
        destination.add(item)
    }
}*/

// Когда функция вызывает методы, имеющие типовой параметр только во входящей (или только в исходящей) позиции,
// мы можем вос пользоваться этим и добавить модификаторы вариантности к конкретным случаям использования типового
// параметра в определении функции.
// В место использования типа можно добавить модификатор "out", это исключит возможность использования методов с типом
// Т в позиции "in"
// #3
/*fun <T> copyData( source: MutableList<out T>,
                  destination: MutableList<T>
                ) {
    for (item in source) {
        destination.add(item)
    }
}*/

// Функция копирования данных с входящей проекцией типового параметра
// #4
fun <T> copyData( source: MutableList<T>,
                  destination: MutableList<in T>) {     // Допускает возможность использования целевой коллекции с
                                                        // элементами другого типа, если он является супертипом для
                                                        // типа элементов в исходной коллекции
    for (item in source) {
        destination.add(item)
    }
}


