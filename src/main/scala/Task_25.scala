object Task_25 {
  def main(args: Array[String]): Unit = {
    val num = 5
    val start = 4
    val end = -12
    var temp = start
    var out = ""

    while(end<=temp){
      if(temp==start){
        out=out+num+"*"+temp
        temp=temp-1
      }
      else{
        out = out +","+ num + "*" + temp
        temp = temp - 1
      }
    }
    println(out)

    temp=start
    out=""

    while (end <= temp) {
      if (temp == start) {
        out = out + (num * temp)
        temp = temp - 1
      }
      else {
        out = out + "," + (num * temp)
        temp = temp - 1
      }
    }
    println(out)

  }
}
