package com.altinawi

class SeatsGenerator {

    private val alphabets = setOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")

    fun createSeats(rows: Int, seatsInRow: Int, firstRowNumber: Int): List<String> {
        var errMsg: String? = null
        if (rows <= 0) errMsg = "rows parameter value must to be 1 or more."
        if (seatsInRow <= 0) errMsg = "seatsInRow parameter value must to be 1 or more."
        if (seatsInRow > alphabets.size) errMsg = "seatsInRow in any row can't be more than ${alphabets.size}"
        if (firstRowNumber <= 0) errMsg = "firstRowNumber parameter value must to be 1 or more."
        errMsg?.let { throw IllegalArgumentException(it) }

        val rangeEnd = firstRowNumber + rows
        return (firstRowNumber until rangeEnd).flatMap { rowIndex ->
            (0 until seatsInRow).map { seatInRow ->
                createSeat(rowIndex = rowIndex, seatLetter = alphabets.elementAt(seatInRow))
            }
        }
    }

    private fun createSeat(rowIndex: Int, seatLetter: String): String = "${rowIndex}${seatLetter}"
}