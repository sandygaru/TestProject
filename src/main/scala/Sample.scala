import scala.io.StdIn

object Sample {
  def main(args:Array[String]):Unit={

    val tuple3: (String, Int, Double) = ("Alice", 30, 170.5)
    println(tuple3._1)
    println(tuple3.productArity)
    println(tuple3.toString())
    println()

    val immutableSet: Set[Int] = Set(1, 2, 3, 4, 5)

    val setA: Set[Int] = Set(1, 2, 3, 4, 5)
    val setB: Set[Int] = Set(4, 5, 6, 7, 8)

    val intersection: Set[Int] = setA.intersect(setB) // Get the intersection of setA and

    println(intersection)
    val union: Set[Int] = setA.union(setB) // Get the union of setA and setB
    println(union)
    val difference: Set[Int] = setB.diff(setA) // Get the elements in setA but not in setB
    println(difference)
    val isSubset: Boolean = setA.subsetOf(setB) // Check if setA is a su
    println(isSubset)

    println()
    val immutableMap: Map[String, Int]
    = Map("apple" -> 1, "banana" -> 2, "orange" -> 3)


    println(immutableMap("apple"))


    val b: Map[String, Int] = immutableMap + ("grapes" -> 5)

    immutableMap.foreach(println)

    println(" down")
    b.foreach(println)

    println()

    var range = 1 to 100

    for(i <- range){
      if(i%3==0 && i%11==0){
        print(i+" ")
      }
    }
    println()
    for (i <- range) {
      if (i % 3 == 0 || i % 11 == 0) {
        print(i + " ")
      }
    }



  }
}
