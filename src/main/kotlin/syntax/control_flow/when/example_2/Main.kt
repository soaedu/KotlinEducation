package syntax.control_flow.`when`.example_2

//import syntax.control_flow.`when`.example_2.Sex.Female
//import syntax.control_flow.`when`.example_2.Sex.Male
//import syntax.control_flow.`when`.example_2.Sex.NonBinary
import syntax.control_flow.`when`.example_2.Sex.Male as M
import syntax.control_flow.`when`.example_2.Sex.Female as F
import syntax.control_flow.`when`.example_2.Sex.NonBinary as NB

import syntax.control_flow.`when`.example_2.MaritalStatus.Married
import syntax.control_flow.`when`.example_2.MaritalStatus.NotMarried
import syntax.control_flow.`when`.example_2.MaritalStatus.Unknown


fun main() {
    println("You can start your letter with: \n\t ${honorify(F, Married)} Smith")
}

fun honorify(sex: Sex, maritalStatus: MaritalStatus) =
    // #1
    /*
    when (Pair(sex, maritalStatus)) {
        Pair(Sex.Male, Married),
        Pair(Sex.Male, NotMarried),
        Pair(Sex.Male, Unknown) -> "Mr."
        Pair(Sex.Female, Married) -> "Mrs."
        Pair(Sex.Female, NotMarried) -> "Miss"
        Pair(Sex.Female, Unknown) -> "Ms."
        Pair(Sex.NonBinary, Married) -> "Mrs."
        Pair(Sex.NonBinary, NotMarried) -> "Miss"
        Pair(Sex.NonBinary, Unknown) -> "Mx."
        else -> throw IllegalArgumentException("Unknown combination of ($sex, $maritalStatus)")
    } */

    // #2 simpler construction
    /*
    when (sex to maritalStatus) {
        Sex.Male to Married,
        Sex.Male to NotMarried,
        Sex.Male to Unknown -> "Mr."
        Sex.Female to Married -> "Mrs."
        Sex.Female to NotMarried -> "Miss"
        Sex.Female to Unknown -> "Ms."
        Sex.NonBinary to Married -> "Mrs."
        Sex.NonBinary to NotMarried -> "Miss"
        Sex.NonBinary to Unknown -> "Mx."
        else -> throw IllegalArgumentException("Unknown combination of ($sex, $maritalStatus)")
    } */

    // #3 simpler construction
    /*
    when (sex to maritalStatus) {
        Male to Married,
        Male to NotMarried,
        Male to Unknown -> "Mr."
        Female to Married -> "Mrs."
        Female to NotMarried -> "Miss"
        Female to Unknown -> "Ms."
        NonBinary to Married -> "Mrs."
        NonBinary to NotMarried -> "Miss"
        NonBinary to Unknown -> "Mx."
        else -> throw IllegalArgumentException("Unknown combination of ($sex, $maritalStatus)")
    } */

    // #4 simpler construction
    when (sex to maritalStatus) {
        M to Married,
        M to NotMarried,
        M to Unknown -> "Mr."
        F to Married -> "Mrs."
        F to NotMarried -> "Miss"
        F to Unknown -> "Ms."
        NB to Married -> "Mrs."
        NB to NotMarried -> "Miss"
        NB to Unknown -> "Mx."
        else -> throw IllegalArgumentException("Unknown combination of ($sex, $maritalStatus)")
    }
