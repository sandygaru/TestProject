import scala.io.StdIn
object Task_12 {
  def main(args: Array[String]): Unit = {
    println("provide ranges to output the even numbers")
    var num1 = StdIn.readInt()
    var num2 = StdIn.readInt()
    val range = num1 to num2

      for (i <- range) {
        if (i % 2 == 0) {
          println(s"Even number --> $i")
      }
    }
  }
}
