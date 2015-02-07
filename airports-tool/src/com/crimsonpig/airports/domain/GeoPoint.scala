package com.crimsonpig.airports.domain

class GeoPoint(val latitude: Double, val longitude: Double) {


}
object GeoPoint {

  def apply(latitude: Double, longitude: Double): GeoPoint = {
    new GeoPoint(latitude, longitude)
  }
  def apply(latString: String, lonString: String): GeoPoint = {
    new GeoPoint(convertLatitudeString(latString), convertLongitudeString(lonString))
  }
  
  private def convertLatitudeString(latString: String): Double = {
    0.0
  }

  private def convertLongitudeString(lonString: String): Double = {
    0.00
  }
}
