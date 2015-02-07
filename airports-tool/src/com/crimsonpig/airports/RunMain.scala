package com.crimsonpig.airports
import com.crimsonpig.airports.domain._
import com.crimsonpig.airports.factory._ 

object RunMain {

  def main(args: Array[String]): Unit = {
    if (args.length == 0) {
        println("No input file specified!")
        return
    }
    if (args.length == 1){
        println("No output file specified")
        return
    }
    val inputFilePath = args(0);
    val outputFilePath = args(1);
    val factory = AbstractAirportFactory("9")
    val airports = factory.getAirportsFromFile(inputFilePath)
    airports.map(println)
    factory.saveAirportsToFile(outputFilePath, airports)
  }

}