package com.crimsonpig.airports.domain

class FS9Airport(identifier: String, location: GeoPoint, elevation: Int) 
	extends Airport(identifier, location, elevation) {
	//EDDF,N50* 01.99830',E08* 34.22730',364
	def toFileLine() = {
	  identifier+','+location.latFileLine+','+location.lonFileLine+','+elevation
	}
	override def toString(): String = {
	  "ident: "+identifier+", lat: "+location.latitude+", lon: "+
	  location.longitude+" elev: "+elevation
	}
}
object FS9Airport {
    def apply(fileString: String): FS9Airport = {
        val parts = fileString.split(",")
        new FS9Airport(parts(0), GeoPoint(parts(1), parts(2)), parts(3).toInt)
    }
}