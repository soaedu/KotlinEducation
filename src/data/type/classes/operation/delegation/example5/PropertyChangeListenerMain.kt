package data.type.classes.operation.delegation.example5

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Пример уведомления обработчиков событий, когда свойство объекта изменяет свое значение.
 */
fun main() {
    val p = Person_( "Dmitry", 34, 2000)
    p.addPropertyChangeListener(
        // Подкпючает обработчик события изменения свойства
        PropertyChangeListener() { event ->
            println("Property ${event.propertyName} changed " +
                    "from ${event.oldValue} to ${event.newValue}"
            )
        }
    )

    p.age = 35
    p.salary = 2100
}

/**
 * Для решения подобных задач в Java есть стандартный механизм, классы: PropertyChangeSupport и PropertyChangeEvent.
 * Класс PropertyChangeSupport управляет списком обработчиков и передает им события PropertyChangeEvent.
 * Чтоб задействовать этот механизм, нужно сохранить экземпляр этого класса в поле класса компонента JavaBean и
 * делегировать ему обработку изменения свойства.
 * Чтобы не добавлять это поле в каждый класс, можно создать маленький вспомогательный класс, который хранит экземпляр
 * PropertyChangeSupport со списком обработчиков событий изменения свойства. Все ваши классы могут наследовать этот
 * вспомогательный класс, чтобы получить доступ к changeSupport.
 */
open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport . addPropertyChangeListener( listener)
    }
    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport . removePropertyChangeListener( listener)
    }
}

/**
 * Реализация передачи уведомлений об изменении свойств вручную
 */
// #1
/*class Person_(val name: String, age: Int, salary: Int): PropertyChangeAware() {
    var age: Int = age
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("age", oldValue, newValue)
        }

    var salary: Int = salary
        set(newValue) {
            // Идентификатор "field" даёт доступ к полю, соответствующему свойству
            val oldValue = field
            field = newValue

            // Уведомляет обработчиков об изменении свойства
            changeSupport.firePropertyChange("salary", oldValue, newValue)
        }
}*/

/**
 * Реализация передачи уведомлений об изменении свойств с применением вспомогательного класса
 */
// #2
/*class ObservableProperty(val propName: String, var propValue: Int, val changeSupport: PropertyChangeSupport) {
    fun getValue(): Int = propValue
    fun setValue(newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(propName, oldValue, newValue)
    }
}
class Person_(val name: String, age: Int, salary: Int): PropertyChangeAware() {
    val _age = ObservableProperty("age", age, changeSupport)
    var age: Int
        get() = _age.getValue()
        set(value) { _age.setValue(value) }

    val _salary = ObservableProperty("salary", salary, changeSupport)
    var salary: Int
        get() = _salary.getValue()
        set(value) { _salary.setValue(value) }
}*/

/**
 * Использование делегирования свойств для передачи извещений об изменении
 */
// #3
// ObservableProperty как объект-делегат для свойств
/*
class ObservableProperty(var propValue: Int, val changeSupport: PropertyChangeSupport) {
    operator fun getValue(p: Person_, prop: KProperty<*>): Int = propValue
    operator fun setValue(p: Person_, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}
class Person_(val name: String, age: Int, salary: Int): PropertyChangeAware() {
    var age: Int by ObservableProperty(age, changeSupport)
    var salary: Int by ObservableProperty(salary, changeSupport)
}*/

/**
 * Вместо реализации логики наблюдения за свойством вручную можно воспользоваться стандартной библиотекой Kotlin.
 * Оказывается, стандартная библиотека уже содержит класс, похожий на ObservableProperty.
 * Но класс в стандартной библиотеке никак не связан с классом PropertyChangeSupport, использовавшимся выше, поэтому
 * требуется передать лямбда-выражение, определяющее, как должны передаваться уведомления об изменении значения свойства.
 *
 * Использование Delegates.observable для отправки уведомлений об изменении свойства
 */
// #4
class Person_(val name: String, age: Int, salary: Int) : PropertyChangeAware( ) {
    private val observer = {
        prop: KProperty<*>, oldValue: Int, newValue: Int ->
            changeSupport.firePropertyChange(prop.name, oldValue, newValue)
        }
    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}
