package com.crimsonpig.airports.domain

abstract class Airport(
	var identifier: String, 
	var location: GeoPoint, 
	var elevation: Int
) {
    def toFileLine(): String;
}
