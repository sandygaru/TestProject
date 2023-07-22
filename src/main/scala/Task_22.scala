object Task_22 {
  def main(args:Array[String]):Unit= {
    var num1 = 100
    var num2 = 10000
    val step=100

   /*
   var series = 100 to 10000
   for(i <- series){   In for loop, i is a val
      print(i)
      i=i+step
    }*/

    while(num1<=num2){
      print(num1+" ")
      num1=num1+step
    }

  }
}
