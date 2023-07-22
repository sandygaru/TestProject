object Task_28 {
  def main(args: Array[String]): Unit = {

    val a1 = 1
    var temp = a1
    var a2 = 25
    var str = ""

    while (temp <= a2) {
      if (temp % 5 == 0) {
        if (a1 == temp) {
          str = str + "divisible by five"
        }
        else {
          str = str + "," + "divisible by five"
        }
      }
      else if(temp%2!=0 ) {
        if (a1 == temp) {
          str = str + temp
        }
        else {
          str = str + "," + temp
        }
      }
      temp = temp + 1
    }
    println(str)

  }
}
