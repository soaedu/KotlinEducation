package syntax.annotations.example_6

/**
 * Object property
 */
// #1 property inside the object without annotation
/*object SuperComputer {
    val answer = 42
}*/

// #2 property inside the object with annotation '@JvmStatic'
/*object SuperComputer {
    @JvmStatic
    val answer = 42
}*/

// #3 property inside the object with annotation '@JvmField'
// Exposing the field for all types of data
/*object SuperComputer {
    @JvmField
    val answer = 42
}*/

// #4 property inside the object without annotation but with
// 'const' keyword.
// Exposing the field for primitive and String type data
/*object SuperComputer {
    const val answer = 42
}*/

/**
 * Top level property
 */
// #5 top level property without annotations
// val answer = 42

// #6 top level property with annotation '@JvmField'
/*
@JvmField
val answer = 42
*/

// #7 top level property without annotations but with
// 'const' keyword.
const val answer = 42
