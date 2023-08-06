object functions {
  def main(args: Array[String]): Unit = {
    printNumbers(1, 10)
    println("****************")
    printOddNumbers(1,10)
  }

  /*  def printNumbers(start: Int, end: Int): Unit = {
    if (start <= end) {
      println(start)
      printNumbers(start + 1, end)
    }
  }*/

  def printNumbers(start: Int, end: Int): Unit = {
    for (num <- start to end) {
      println(num)
    }
  }

  def printOddNumbers(start: Int, end: Int): Unit = {
    for (num <- start to end) {
      if(num%2!=0) {
        println(num)
      }
    }
  }
}
