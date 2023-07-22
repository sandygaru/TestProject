object Task_20 {
  def main(args:Array[String]):Unit= {
    var a = ""
    var b = 0 until 100
    var c=""

    for(i <- b){
      if(i%2==0){
        if(i==0){
          c = c + "A"
        }else {
          c = c + ", A"
        }
      }else{
        if (i == 0) {
          c = c + "B"
        } else {
          c = c + ", B"
        }
      }
    }
    println(c)
  }
}
