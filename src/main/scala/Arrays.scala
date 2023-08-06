import scala.io.StdIn

object Arrays {

  def main(args:Array[String]):Unit={
    //Static Array
    var arr = Array(1,2,3,4,5,6,7,8,9,10)



    var range = 0 to arr.length-1

    for(a <- range){
      if(arr(a) % 2 == 0){
        print(arr(a)+",")
      }
    }

    println()

    for (a <- range) {
      if (a%2 == 0) {
        print(arr(a)+",")
      }
    }


    println()
    //dynamic Array
    println("provide the size")
    val size=StdIn.readInt()
    val arr1 = new Array[Int](size)

    for(i<- 0 until size){
      println("give  ith index value : ",i)
       arr1(i) = StdIn.readInt()
    }
    for (i <- 0 until size) {
      println(arr1(i))
    }

    for (a <- 0 until size) {
      if (arr(a) % 2 == 0) {
        print(arr1(a) + ",")
      }
    }

    println()

    for (a <- 0 until size) {
      if (a % 2 == 0) {
        print(arr1(a) + ",")
      }
    }
    println("*****************************")
arr1.foreach(println)
    println("*****************************")
    val squaredNumbers: Array[Int] = arr1.map(number => number * number)
    squaredNumbers.foreach(println)
    println("*****************************")
    val filteredNumbers: Array[Int] = arr1.filter(_ % 2 == 0)
    //filteredNumbers.foreach(println())
    println("*****************************")
    val sortedNumbers: Array[Int] = arr1.sortBy(number => -number)  //-number refers descending
    //sortedNumbers.foreach(println())
  }
}
