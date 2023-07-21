object Task_10 {
  def main(args:Array[String]):Unit={

    val range = 700 to 900 //to <--> until
    for (i <- range) {
      if (i % 2 == 0) {
        print("   ")
        print(s"$i")
      }

    }
  }
}
