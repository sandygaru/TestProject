import scala.io.StdIn
object Kg_g {
  def main(args:Array[String]):Unit= {
    println("Please provide input in Kg :-")
    var kg = StdIn.readDouble()
    var g= kg*1000
    println(s"$kg kg --> $g g")
  }
}
