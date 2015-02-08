package com.crimsonpig.airports.domain

/*GeoPoint stores latitude and longitude as radians. */
class GeoPoint(val latitude: Double, val longitude: Double) {
	def latFileLine(): String = {
	  var latString = if(latitude >= 0.0) "N" else "S"
	  latString
	}
	def lonFileLine(): String = {
	  ""
	}
}
object GeoPoint {

  def apply(latitude: Double, longitude: Double): GeoPoint = {
    new GeoPoint(latitude, longitude)
  }
  def apply(latString: String, lonString: String): GeoPoint = {
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
  
  private def fs9LatLonStringToRadians(latLonString: String, negative: Boolean): Double = {
    val degrees = latLonString.substring(1, latLonString.indexOf('*')).toDouble
    val period = latLonString.indexOf('.')
    val minutes = latLonString.substring(latLonString.indexOf(' ')+1,period).toDouble
    val seconds = latLonString.substring(period+1, latLonString.indexOf('\'')).toDouble
    val radians = (degrees + (minutes / 60) + (seconds / 3600)) * ((Math.PI * 2) / 360.0)
    if (negative) -radians else radians  
  }
}
