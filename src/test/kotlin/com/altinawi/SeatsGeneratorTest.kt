package com.altinawi

import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.Test

class SeatsGeneratorTest {

    private val seatsGenerator = SeatsGenerator()

    @Test
    fun `basic test`() {
        val expectedResult1 = listOf("1A", "1B", "1C", "1D", "2A", "2B", "2C", "2D")
        val actualResult1 = seatsGenerator.createSeats(rows = 2, seatsInRow = 4, firstRowNumber = 1)
        assertEquals(expected = expectedResult1, actual = actualResult1)

        val expectedResult2 = listOf("3A", "3B", "4A", "4B")
        val actualResult2 = seatsGenerator.createSeats(rows = 2, seatsInRow = 2, firstRowNumber = 3)
        assertEquals(expected = expectedResult2, actual = actualResult2)
    }

    @Test
    fun `illegal argument exception test`() {
        assertFailsWith(exceptionClass = IllegalArgumentException::class, message = "rows parameter value must to be 1 or more.") {
            seatsGenerator.createSeats(rows = 0, seatsInRow = 4, firstRowNumber = 1)
        }

        assertFailsWith(exceptionClass = IllegalArgumentException::class, message = "seatsInRow parameter value must to be 1 or more.") {
            seatsGenerator.createSeats(rows = 1, seatsInRow = 0, firstRowNumber = 1)
        }

        assertFailsWith(exceptionClass = IllegalArgumentException::class, message = "seatsInRow in any row can't be more than 26") {
            seatsGenerator.createSeats(rows = 2, seatsInRow = 27, firstRowNumber = 1)
        }

        assertFailsWith(exceptionClass = IllegalArgumentException::class, message = "seatsInRow parameter value must to be 1 or more.") {
            seatsGenerator.createSeats(rows = 1, seatsInRow = 4, firstRowNumber = 0)
        }
    }
}