package data.type.standard_type.collection_type.type.list_type.example_5

fun main() {
    // #1
    // When we call 'getList()' method we receive a read-only 'List'
    val list = getList()
    // Error: Unresolved reference 'add'
    // list.add(4)
    println("Show values of the 'list': $list")

    // #2
    val mutableList = mutableListOf(1)
    val readOnlyList: List<Int> = mutableList

    println(
        "Show info about:" +
        "\n\tequality of 'mutableList' and 'readOnlyList': ${mutableList == readOnlyList}"+
        "\n\tmutableList: $mutableList" +
        "\n\treadOnlyList: $readOnlyList"
    )

    mutableList.add(2)
    // readOnlyList.add(2)
    println(
        "\nShow info about:" +
        "\n\tequality of 'mutableList' and 'readOnlyList': ${mutableList == readOnlyList}" +
        "\n\tmutableList: $mutableList" +
        "\n\treadOnlyList: $readOnlyList"
    )

}

fun getList(): List<Int> {
    return mutableListOf(1, 2, 3)
}
