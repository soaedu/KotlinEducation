package data.type.classes.operation.delegation.example6

/**
 * Общая схема реализации делегирования свойства.
 */
fun main() {
    // val с = С()
}

/*class С {
    var prop: Туре by MyDelegate()
}*/

/**
 * Экземпляр MyDelegate будет хранить скрытое свойство (назовем его <delegate>).
 * Для представления свойства компилятор будет использовать объект типа KProperty (назовем его <property>)
 *
 * Внутри каждого метода доступа свойства компилятор вызовет соответствующие методы getValue и setValue
 *  val x = c.prop  ->  val x = delegate.getValue(c, <property>)
 *  c.prop = x      ->  delegate.setValue(c, <property>, x)
 */
/*class С {
    private val <delegate> = MyDelegate()

    var prop: Туре
        get() = <delegate>.getValue(this, <property>)
        set(value: Туре) = <delegate>.setValue(this, <property>, value)
}*/
