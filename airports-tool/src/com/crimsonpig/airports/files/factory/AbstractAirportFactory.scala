package com.keith.fs.files.factory

import com.crimsonpig.airports.domain._

trait AbstractAirportFactory {  
	def getAirportsFromFile(filePath:String):List[Airport]
	def saveAirportsToFile(filePath:String, airports: List[Airport]):Unit
}