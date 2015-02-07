package com.crimsonpig.airports.factory

import com.crimsonpig.airports.domain._
import com.crimsonpig.airports.domain.FS9Airport

class FS9AirportFactory extends AbstractAirportFactory {

	def getAirportsFromFile(filePath:String): List[Airport] = {
		val fileLines = io.Source.fromFile(filePath).getLines.toList
   	  	fileLines.map(fileLine => FS9Airport(fileLine))
	}
	
	def saveAirportsToFile(filePath:String, airports: List[Airport]): Unit = {
	  
	}

	

}