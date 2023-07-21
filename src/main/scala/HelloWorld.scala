object HelloWorld {
  def main(args:Array[String]):Unit={

    val a:Int=10  //4 bytes of memory - int

    var b:String="Hi" //2 bytes of memory * length of the string - string

    //scala has type infering language
    val c=45

    val d="santhosh"

    val e=1.2f  //4 bytes of memory - float

    val f=56.13  //8 bytes of memory - double

    val h=566641616L  //8 bytes of memory - long

    val g='A'   //2 bytes of memory - char

    //a=a+10 //--> reassignment to val

    print("Hello World " + a + " "+b+" "+c+" "+d)

    println("")

    val name = "Alice"
    val age = 30
    val message = s"My name is $name and I'm $age years old."
    println(message) // Output: My name is Alice and I'm 30 years old
    println(10%20)
    println(1/2.0)

    val num=25
    if(num%2!=0)
      {
        println("Its an ODD")
      }
    else
      {
        println("Its not an ODD")
      }

    val range = 1 to 100 //to <--> until
    for(i<-range){
      if(i%2==0) {
        print("   ")
        print(s"$i")
      }
    }

    println("")
    var a1=1
    while(a1<100){
      if(a1%2==0) {
        println(s"$a1")
        a1=a1+2
      }
      a1=a1+1
    }


  }
}
