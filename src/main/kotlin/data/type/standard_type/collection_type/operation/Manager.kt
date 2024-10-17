package data.type.standard_type.collection_type.operation

data class Manager(
    override val name: String,
    override val age: Int,
    override val male: Boolean
): Person(name, age, male)
