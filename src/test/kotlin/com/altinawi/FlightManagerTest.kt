package com.altinawi

import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class FlightManagerTest {

    private val flightManager = FlightManager()
    private val flight1 = Flight("LO1533", "WAW", "MUC")
    private val flight2 = Flight("LH1232", "JFK", "PAR")
    private val flight3 = Flight("YH1732", "PAR", "JFK")
    private val flight4 = Flight("lo1533", "waw", "muc")
    private val flight5 = Flight("ti1533", "muc", "waw")

    @Test
    fun `add a new flight`() {
        assertTrue(actual = flightManager.addNewFlight(flight = flight1))
    }

    @Test
    fun `add a new flight lower case`() {
        assertTrue(actual = flightManager.addNewFlight(flight = flight4))
    }

    @Test
    fun `add an existing flight`() {
        flightManager.addNewFlight(flight = flight1)
        assertFalse(actual = flightManager.addNewFlight(flight = flight4))
    }

    @Test
    fun `finds valid connection`() {
        val expectedResult1 = listOf(flight2, flight3)

        flightManager.addNewFlight(flight = flight1)
        flightManager.addNewFlight(flight = flight2)
        flightManager.addNewFlight(flight = flight3)

        val actualResult1 = flightManager.findFlightsBetween(origin = "JFK", destination = "PAR", directionSensitive = false)

        assertEquals(expected = expectedResult1, actual = actualResult1)

        val expectedResult2 = listOf(flight1, flight5.toUppercase())

        flightManager.addNewFlight(flight = flight5)

        val actualResult2 = flightManager.findFlightsBetween(origin = "muc", destination = "waw", directionSensitive = false)

        assertEquals(expected = expectedResult2, actual = actualResult2)
    }
}