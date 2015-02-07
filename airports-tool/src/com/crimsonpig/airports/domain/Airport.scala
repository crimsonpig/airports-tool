package com.crimsonpig.airports.domain

class Airport(
	var identifier: String, 
	var latitude: Double, 
	var longitude: Double, 
	var elevation: Int
) {
    def toFileLine(): String = {
        ???
    }
}
object Airport {
	def fromFileLine(line: String): Airport = {
		???
	}
}
