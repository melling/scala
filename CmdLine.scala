/*
 * scalac -d classes CmdLine.scala
 *
 * scala -classpath classes  Main
 * scala -classpath classes  Main -h
 * scala -classpath classes  Main -verbose
 */

object Main {
  var verbose = false

  def main(args: Array[String]):Unit = {
    for (a <- args) a match {
      case "-h" | "-help"    =>
        println("Usage: scala Main [-help|-verbose]")
      case "-v" | "-verbose" =>
        verbose = true
      case x =>
        println("Unknown option: '" + x + "'")
    }
    if (verbose)
      println("How are you today?")
  }
}

