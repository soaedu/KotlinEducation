package unit_testing.test_package.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import unit_testing.source_package.math.MathOperations

class MathOperationsTests {
    @Test
    fun checkSqrtCalculation() {
        val obj = MathOperations()

        assertEquals(5.0, obj.calculateSqrt(25), 0.5)
        assertEquals(1.0, obj.calculateSqrt(1), 0.5)
    }
}