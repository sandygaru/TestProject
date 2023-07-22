object Task_31 {
  def main(args: Array[String]): Unit = {
    var range1 = 1 to 3

    var range2 = 5 to 7

    for(i <- range1)
      {
        for(j <- range2){
          println(i +" --> "+j)
        }
        println("**********")
      }
  }
}
