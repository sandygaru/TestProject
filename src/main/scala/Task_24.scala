object Task_24 {
  def main(args: Array[String]): Unit = {
    var a = ""
    var b = 0 until 7
    var c = ""

    for (i <- b) {
      if (i % 2 == 0) {
        if (i == 0) {
          c = c + "5"
        } else {
          c = c + ", 5"
        }
      } else {
        if (i == 0) {
          c = c + "10"
        } else {
          c = c + ", 10"
        }
      }
    }
    println(c)
  }
}
