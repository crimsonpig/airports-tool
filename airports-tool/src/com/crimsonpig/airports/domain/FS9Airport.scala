package com.crimsonpig.airports.domain

class FS9Airport(identifier: String, location: GeoPoint, elevation: Int) 
	extends Airport(identifier, location, elevation) {
	def toFileLine() = {
	  ""
	}
}
