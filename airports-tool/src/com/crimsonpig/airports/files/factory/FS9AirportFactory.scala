package com.keith.fs.files.factory

import com.crimsonpig.airports.domain._
import com.crimsonpig.airports.domain.FS9Airport

class FS9AirportFactory extends AbstractAirportFactory {

	def getAirportsFromFile(filePath:String): List[Airport] = {
		val fileLines = io.Source.fromFile(filePath).getLines.toList
   	  	fileLines.map(fileLine => fromLineToAirport(fileLine))
	}
	
	def saveAirportsToFile(filePath:String, airports: List[Airport]): Unit = {
	  
	}
  	
	private def fromLineToAirport(line:String): FS9Airport = {
  	  val fpAc= line.split(",")
  	  val id = fpAc(0).drop(3).toInt
  	  val airspeed = fpAc(1).toInt
  	  val title = fpAc(2).replaceAll("\"","")
	  new FS9Aircraft(id,airspeed,title)
  	}

	

}