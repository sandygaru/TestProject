import scala.io.StdIn
object Task_6 {
  def main(args:Array[String]):Unit= {
    var a=0
    while(a==0){
      println("select operation to do")
      println("1. add 2. subtract 3. multiply 4. divide <type any int to exit>")
      var oper = StdIn.readInt()

      if(oper<5) {
        println("provide 2 input values to operate")
        var num1 = StdIn.readInt()
        var num2 = StdIn.readInt()

        var output = oper match {
          case 1 => s"adding $num1 and $num2 :- " + (num1 + num2)
          case 2 => s"subtracting $num1 and $num2 :- " + (num1 - num2)
          case 3 => s"multiplying $num1 and $num2 :- " + (num1 * num2)
          case 4 => s"dividing $num1 and $num2 :- " + (num1 / num2)
        }

        println(s"$output")
      }
      else {
        a=1
        println("Bubye!!!")
      }
      println("********************************************************")
    }
  }
}
