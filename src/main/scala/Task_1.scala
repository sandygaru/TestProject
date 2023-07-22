import scala.io.StdIn
object Task_1 {
  def main(args:Array[String]):Unit= {
    println("Please provide input in Kg :-")
    var kg = StdIn.readDouble()
    var g= kg*1000
    println(s"$kg kg --> $g g")
  }
}
