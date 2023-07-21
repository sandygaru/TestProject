object Task_13 {
  def main(args: Array[String]): Unit = {
    var a1 = 20
    var a2 = 140
    var str=""
    var str1=""

    while (a1 <= a2) {
      if (a1 % 2 == 0) {
        str=str+","+a1
        a1 = a1 + 2
      }
      a1 = a1 + 1
    }
    println(str)
    if (str(0) == ',') {
      var range = 1 to str.length - 1
      for (i <- range) {
        str1 = str1 + str(i)
      }
    }

    println(str1)
  }
}
