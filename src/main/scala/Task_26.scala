object Task_26 {
  def main(args: Array[String]): Unit = {

    val a1 = 1
    var temp = a1
    var a2 = 36
    var str = ""

    while (temp <= a2) {
      if (temp % 2 == 0) {
        if(a1 == temp) {
          str = str + "even"
        }
        else{
          str = str + "," + "even"
        }
      }
      else{
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
