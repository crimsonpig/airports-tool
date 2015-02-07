package com.crimsonpig.airports
import com.crimsonpig.airports.domain._
import com.crimsonpig.airports.factory._ 

object RunMain {

  def main(args: Array[String]): Unit = {
    if (args.length == 0) {
        println("No airports file specified!")
        return
    }
    var airportsFilePath = args(0);
    val factory = AbstractAirportFactory("9")
    factory.getAirportsFromFile(airportsFilePath).map(println)
  }

}