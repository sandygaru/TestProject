object Task_15 {
  def main(args: Array[String]): Unit = {
    var num1 = 2
    var num2 = 17
    var str=""
    var str1=""

    var range = num1 to num2-1

    for (i <- range) {
      if(num1==i) {
        str=str+i+"*"+(i+1)
      }
      else {
        str=str+","+i+"*"+(i+1)
      }
    }

    println(str)

    for (i <- range) {
      if (num1 == i) {
        str1 = str1 + (i * (i + 1))
      }
      else {
        str1= str1 + "," + (i * (i + 1))
      }
    }
    println(str1)
  }
}
