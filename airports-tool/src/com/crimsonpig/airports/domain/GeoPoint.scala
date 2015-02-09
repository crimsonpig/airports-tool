package com.crimsonpig.airports.domain

/*GeoPoint stores latitude and longitude as radians. */
class GeoPoint(val latitude: Double, val longitude: Double) {
	def latFileLine(): String = {
	  var latString = if(latitude >= 0.0) "N" else "S"
	  val degreeVal = Math.abs(latitude.toDegrees)
	  val truncatedDegrees = truncateDegrees(degreeVal)
	  "%s%02d* %s'".format(latString, truncatedDegrees, zeroPadMinutes(truncateMinutes(degreeVal, truncatedDegrees)))
//	  latString
	}
	def lonFileLine(): String = {
	  var lonString = if(longitude >= 0.0) "E" else "W"
	  val degreeVal = Math.abs(longitude.toDegrees)
	  val truncatedDegrees = truncateDegrees(degreeVal)
//	  lonString += truncatedDegrees + "* " + truncateMinutes(degreeVal, truncatedDegrees) + '\''
	  "%s%02d* %s'".format(lonString, truncatedDegrees, zeroPadMinutes(truncateMinutes(degreeVal, truncatedDegrees)))
//	  lonString
	}
	
	private def zeroPadMinutes(minutes: Double): String = {
	    val minString = "%2.5f".format(minutes)
	    if(minutes <= 9.99999) "0"+minString else minString
	}
	
	private def truncateDegrees(value: Double): Int = {
	    ((value * 100.0) / 100.0).toInt
	} 
	//val totalDegrees = degrees + (minutes / 60)
	//val totalDegrees - degrees = minutes / 60
	//val (totalDegrees - degrees) * 60 = minutes
	private def truncateMinutes(totalDegrees: Double, truncatedDegrees: Int): Double = {
		(((totalDegrees - truncatedDegrees) * 60.0) ) 
	}
}
object GeoPoint {

  def apply(latitude: Double, longitude: Double): GeoPoint = {
    new GeoPoint(latitude, longitude)
  }
  def apply(latString: String, lonString: String): GeoPoint = {
//    println(latString+", "+convertLatitudeString(latString))
//    println(lonString+", "+convertLongitudeString(lonString))
    new GeoPoint(convertLatitudeString(latString), convertLongitudeString(lonString))
  }
  //N35* 45.88330'
  //S34* 49.33330'
  private def convertLatitudeString(latString: String): Double = {
    fs9LatLonStringToRadians(latString, latString.charAt(0) == 'S')
  }
  //E140* 23.18330'
  //W58* 32.15000'
  private def convertLongitudeString(lonString: String): Double = {
    fs9LatLonStringToRadians(lonString, lonString.charAt(0) == 'W');
  }
  //deg * 2pi/360 = rad
  //deg = rad * 360/2pi
  private def fs9LatLonStringToRadians(latLonString: String, negative: Boolean): Double = {
    val degrees = latLonString.substring(1, latLonString.indexOf('*')).toDouble
    val minutes = latLonString.substring(latLonString.indexOf(' ')+1,latLonString.indexOf('\'')).toDouble
    val totalDegrees = (degrees + (minutes / 60))
    val radians = totalDegrees.toRadians
    if (negative) -radians else radians  
  }
}
