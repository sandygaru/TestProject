import scala.io.StdIn
object Task_4 {
  def main(args:Array[String]):Unit= {
    println("Provide a variable for custom testing : ")
    var num = StdIn.readInt()
    if(num>=100 & num<=1000){
      if(num%2==0){
        println("EVEN "+num%3)
      }else{
        println("ODD "+num%2)
      }
    }
    else{
      println(s"$num is a Wrong Number")
    }
  }
}
