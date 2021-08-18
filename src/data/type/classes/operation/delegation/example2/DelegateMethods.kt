package data.type.classes.operation.delegation.example2

// #1
/*class FlexibleSet<T>(private val threshold: Int = 4): MutableSet<T> {
    private var innerSet: MutableSet<T> = COWArraySet<T>()

    override val size: Int
        get() = innerSet.size

    override fun contains(element: T): Boolean =
        innerSet.contains(element)

    override fun containsAll(elements: Collection<T>): Boolean =
            innerSet.containsAll(elements)

    override fun isEmpty(): Boolean =
            innerSet.isEmpty()*//*

    override fun add(element: T): Boolean =
            flex { innerSet.add(element) }

    override fun addAll(elements: Collection<T>): Boolean =
            flex { innerSet.addAll(elements) }

    override fun clear() = flex { innerSet.clear() }

    private inline fun <R> flex(body: () -> R): R {
        val res = body()
        when {
            innerSet is HashSet
                    && innerSet.size < threshold -> {
                val oldSet = innerSet
                innerSet = COWArraySet()
                innerSet.addAll(oldSet)
            }
            // ...
        }
        return res
    }
}*/

// #2
// все неперегруженные вызовы будут делегироваться полю "innerSet"
// перегруженные вызовы будут работать в соответствии с реализацией
/*class BetterFlexibleSet<T>(
        private val threshold: Int = 4,
        private var innerSet: MutableSet<T> = COWArraySet<T>()): MutableSet<T> by innerSet {

    // ...
}*/

/*
// #1
data class MutableFileTree(
        private val data: MutableMap<String, MutableFileTree> = mutableMapOf(),
        var changed: Boolean = false): MutableMap<String, MutableFileTree> {

    // Here will be a lot of delegation...
}
*/

// #2
data class MutableFileTree(
        private val data: MutableMap<String, MutableFileTree> = mutableMapOf(),
        // #1
        var changed: Boolean = false): MutableMap<String, MutableFileTree> by data {

        // #2
        // possible
        // var changed: Boolean = false): MutableMap<String, MutableFileTree> by data {
        //     override some methods, fields, properties
        // }
}
