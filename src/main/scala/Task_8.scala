object Task_8 {
  def main(args:Array[String]):Unit= {
    var num1 = 250
    var num2 = 550

    val range = num1 to num2
    for (i <- range) {
      if(i%11==0) {
        println(s"Divisible by 11 --> $i")
      }
    }
  }
}
