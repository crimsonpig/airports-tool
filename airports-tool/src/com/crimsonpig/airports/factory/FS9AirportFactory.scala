package com.crimsonpig.airports.factory

import com.crimsonpig.airports.domain._
import com.crimsonpig.airports.domain.FS9Airport
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter

class FS9AirportFactory extends AbstractAirportFactory {

	def getAirportsFromFile(filePath:String): List[Airport] = {
		val fileSource = io.Source.fromFile(filePath)
		val fileLines = fileSource.getLines.toList
   	  	val airportsList = fileLines.map(fileLine => FS9Airport(fileLine))
   	  	fileSource.close
   	  	airportsList
	}
	
	def saveAirportsToFile(filePath:String, airports: List[Airport]): Unit = {
	    val writer = new PrintWriter(new File(filePath))
	    for(airport <- airports){
	      writer.println(airport.toFileLine)
	    }
	    writer.close
	}

	

}