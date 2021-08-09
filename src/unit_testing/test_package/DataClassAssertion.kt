package unit_testing.test_package

import org.junit.jupiter.api.Test

class DataClassAssertion {
/*    @Test
    fun test() {
        // #1 - Bad solution
        assertThat(actualDesign.id).isEqualTo(2)
        assertThat(actualDesign.userId).isEqualTo(9)
        assertThat(actualDesign.name).isEqualTo("Cat")

        // #2 - Good solution
        val expectedDesign = Design(id = 2, userId = 9, name = "Cat")
        assertThat(actualDesign).isEqualTo(expectedDesign)


        assertThat(actualDesign).containsExactly(
            Design(id = 1, userId = 9, name = "Cat"),
            Design(id = 2, userId = 4, name = "Dog")
        )

        // Single element
        assertThat(actualDesign).isEqualToIgnoringGivenFields(expectedDesign, "id")
        assertThat(actualDesign).isEqualToComparingOnlyGivenFields(expectedDesign, "name")

        // List
        assertThat(actualDesign).usingElementComparatorIgnoringFields("id")
                .containsExactly(expectedDesign1, expectedDesign2)
        assertThat(actualDesign).usingElementComparatorOnFields("name")
                .containsExactly(expectedDesign1, expectedDesign2)

    }*/
}