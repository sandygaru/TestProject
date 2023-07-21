object Task_9 {
  def main(args: Array[String]): Unit = {
    var num1 = 56
    var num2 = 153
    var total=0

    val range = num1 to num2
    for (i <- range) {
      total=total+i;
    }
    println(s"suming all numbers from $num1 to $num2 --> $total")
  }
}
