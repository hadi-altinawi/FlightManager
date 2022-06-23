package com.altinawi

data class Flight(val flightNumber: String, val origin: String, val destination: String) {
    fun toUppercase(): Flight =
        this.copy(flightNumber = flightNumber.uppercase(), origin = origin.uppercase(), destination = destination.uppercase())
}

class FlightManager {

    private val flights = mutableListOf<Flight>()

    fun addNewFlight(flight: Flight): Boolean {
        val exist = flights.any { it.flightNumber == flight.flightNumber.uppercase() }
        return if (exist) {
            false
        } else {
            flights.add(flight.toUppercase())
            true
        }
    }

    fun findFlightsBetween(origin: String, destination: String, directionSensitive: Boolean): List<Flight> {
        val originUppercase = origin.uppercase()
        val destinationUppercase = destination.uppercase()
        return flights.filter {
            if (directionSensitive) it.origin == originUppercase && it.destination == destinationUppercase
            else (it.origin == originUppercase && it.destination == destinationUppercase) || (it.origin == destinationUppercase && it.destination == originUppercase)
        }
    }
}