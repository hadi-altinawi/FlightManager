## Flight Manager in Kotlin

You are creating an [MVP](https://en.wikipedia.org/wiki/Minimum_viable_product) of an application responsible for managing flights data.

## Problem statement

1. Make tests pass by implementing missing features in the code.

2. Make the app work in a way described below.  The majority of the code is committed but there are some missing pieces to implement.

## Missing features

- Implement SeatsGenerator.createSeats(rows: Int, seatsInRow: Int, firstRowNumber: Int): List<String>
which would generate a list of seats for the given parameters.
Each seat represented as an element of the list is a string in the following format:

  `<row_number><seat_in_a_row>`

  where:

  `<row_number>` is a decimal number of a row
  
  `<seat_in_a_row>` is a capital letter

  Example:

  ```seatsGenerator.createSeats(2, 4, 1) => [1A, 1B, 1C, 1D, 2A, 2B, 2C, 2D]```

- Having flight represented as data class `Flight(val flightNumber: String, val origin: String, val destination: String)`
implement `FlightManager.addNewFlight(flight: Flight): Boolean` that would add flight and return true if the adding operation is successful. The requirement is that you cannot add a flight if there is a flight with the same flight number. 

- Implement `FlightManager.findFlightsBetween(origin: String, destination: String, directionSensitive: Boolean): List<Flight>` which should return a list of flight connections between passed airports.  If `directionSensitive` is equal to false, then the method should return all flights from origin to destination AND from destination to origin. 

  For example, if following connections are available:

  WAW  ->  MUC
  
  JFK  ->  PAR
  
  PAR  ->  JFK

```
flightManager.findFlightsBetween("JFK", "PAR", false) => [
                       Flight(flightNumber=LH1232, origin=JFK, destination=PAR),
                       Flight(flightNumber=YH1732, origin=PAR, destination=JFK)
                       ]
                                                