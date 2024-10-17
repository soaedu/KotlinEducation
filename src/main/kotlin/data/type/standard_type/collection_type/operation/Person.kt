package data.type.standard_type.collection_type.operation

data class Person(val name: String, val age: Int, val male: Boolean) {
    fun isAdult(p: Person) = p.age > 18
    fun isChild(p: Person) = p.age < 18
    fun isMale(p: Person) = p.male
    fun isFemale(p: Person) = !p.male
}
