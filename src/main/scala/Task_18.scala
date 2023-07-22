object Task_18 {
  def main(args:Array[String]):Unit= {
    var range = 24 to 100
    var count = 0
    var sum = 0

    for(i <- range){
      count=count+1
      sum=sum+i
    }

    println("Average "+sum/count)
  }
}
