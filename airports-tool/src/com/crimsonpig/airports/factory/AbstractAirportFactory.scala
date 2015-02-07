package com.crimsonpig.airports.factory

import com.crimsonpig.airports.domain._

trait AbstractAirportFactory {  
	def getAirportsFromFile(filePath:String):List[Airport]
	def saveAirportsToFile(filePath:String, airports: List[Airport]):Unit
}
object AbstractAirportFactory {
    def apply(version: String): AbstractAirportFactory = {
       if(version== "9") { return new FS9AirportFactory() }
       else null
    }
}