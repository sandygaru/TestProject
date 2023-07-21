import scala.io.StdIn
object Cel_fah {
  def main(args:Array[String]):Unit= {
    println("Please provide input in Celsius(\u00B0C) :- ")
    var cel = StdIn.readInt()
    println(s"Celsius $cel"+"\u00B0C --> "+ (cel*1.8+32).toInt +"\u00B0F")
  }
}
