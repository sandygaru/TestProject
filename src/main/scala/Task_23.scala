object Task_23 {
  def main(args: Array[String]): Unit = {
    var num1 = 5
    var num2 = 25
    val step = 2

    while (num1 <= num2) {
      print(num1*num1 + " ")
      num1 = num1 + step
    }

  }
}
