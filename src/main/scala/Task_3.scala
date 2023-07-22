import scala.io.StdIn

object Task_3 {
  def main(args:Array[String]):Unit= {
    println("Provide 3 variables to find biggest number : ")
    var num1 = StdIn.readInt()
    var num2 = StdIn.readInt()
    var num3 = StdIn.readInt()

    if (num1 > num2 & num1 > num3) {
      println(s"$num1 is bigger")
    }
    else if (num2 > num1 & num2 > num3) {
      println(s"$num2  is bigger")
    }
    else {
      println(s"$num3  is bigger")
    }
  }
}
