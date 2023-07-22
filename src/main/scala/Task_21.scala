object Task_21 {
  def main(args:Array[String]):Unit= {
    val num1 = 5
    val num2 = 10
    var temp = num2
    var out = ""
    while(temp>num1){
      if(num2 == temp){
        out = out + (temp + "@"+ (temp-1))
      }
      else {
        out = out + (","+temp + "@" + (temp - 1))
      }
      temp = temp-1
    }
    println(out)
  }
}
