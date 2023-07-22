object Task_29 {
  def main(args: Array[String]): Unit = {

    val a1 = 0.5
    var temp = a1
    var a2 = 5.3
    var str = ""

    while (temp <= a2) {

        if (a1 == temp) {
          str = str + (temp * temp)
        }
        else {
          str = str + "," + (temp * temp)
        }

      temp = temp + 0.2
    }
    println(str)

  }
}
