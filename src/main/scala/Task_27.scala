object Task_27 {
  def main(args: Array[String]): Unit = {

    val a1 = 1
    var temp = a1
    var a2 = 24
    var str = ""

    while (temp <= a2) {
      if (temp % 3 == 0) {
        if (a1 == temp) {
          str = str + "factor of three"
        }
        else {
          str = str + "," + "factor of three"
        }
      }
      else {
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
