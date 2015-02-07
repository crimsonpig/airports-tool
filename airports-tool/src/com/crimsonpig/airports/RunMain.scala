package com.crimsonpig.airports
import com.crimsonpig.airports.domain._


object RunMain {

  def main(args: Array[String]): Unit = {
    if (args.length == 0) {
        println("No airports file specified!")
        return
    }
    val airportsFilePath = args(0);
    val airport:Airport = new FS9Airport("KLAX", 0.00, 0.00, 13);
  }

}