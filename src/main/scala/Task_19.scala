object Task_19 {
  def main(args:Array[String]):Unit= {
    var num = 5 to 102
    var sum = 0
    for(i <- num){
      sum = sum + (i * i)
      //println(sum +" ")
    }
    println(sum)
  }
}
