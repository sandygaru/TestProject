object Task_5 {
  def main(args:Array[String]):Unit= {
    var a = 78;

    if(a<0 | a>=100){
      println("Invalid Input")
    }
    else{
      if(a>=90){
        println("Super Smart")
      }
      else if(a>=80){
        println("Smart")
      }
      else if(a>=70){
        println("Smart Enough")
      }
      else if(a>=60){
        println("Just Smart")
      }
      else if(a>=35){
        println("No Smart")
      }
      else{
        println("Dump")
      }
    }


  }
}
