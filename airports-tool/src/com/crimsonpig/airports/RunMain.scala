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
    factory.saveAirportsToFile(outputFilePath, airports)
//  val x = GeoPoint("N20* 59.59830'","W101* 28.85780'")
//    val x = GeoPoint("N38* 53.23'","W77* 00.32'")
//    val x = GeoPoint("N36* 10.00000'","E137* 55.36670'")
//    println(x.latFileLine)
//    println(x.lonFileLine)
  }

}