object Task_11 {
  def main(args: Array[String]): Unit = {
    var num1 = 251
    var num2 = 51

    while(num1>=num2){
      if (num1 % 2 != 0) {
        print(s"$num1")
        if(num1!=num2){
          print(",")
        }
      }
      num1=num1-1;
    }

  }
}
