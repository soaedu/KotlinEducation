package data.type.standard_type.collection_type.operation

open class Person(
    open val name: String,
    open val age: Int,
    open val male: Boolean
) {
    fun isAdult(p: Person) = p.age > 18
    fun isChild(p: Person) = p.age < 18
    fun isMale(p: Person) = p.male
    fun isFemale(p: Person) = !p.male
}
