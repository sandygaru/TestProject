object Task_16 {
  def main(args: Array[String]): Unit = {
    var num1 = 382
    var num2 = 582
    var total = 0

    val range = num1 to num2
    for (i <- range) {
      if(i%2==0) {
        total = total + i;
      }
    }
    println(s"even numbers between $num1 to $num2 --> $total")
  }
}
