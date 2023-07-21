import scala.io.StdIn

object Sample {
  def main(args:Array[String]):Unit={

    println("give 2 integer value to print odd values into it")
    var num1=StdIn.readInt()
    var num2=StdIn.readInt()
    while (num1 <= num2) {
      if (num1 % 2 != 0) {
        println(s"$num1")
        num1 = num1 + 2
      }
      num1 = num1 + 1
    }


  }
}
