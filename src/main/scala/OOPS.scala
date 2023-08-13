object OOPS {
  def main(args: Array[String]): Unit = {
    val obj = new Person("karthik", 20) //object //instatting
    val result = obj.square(20)
    println(s"Square of 20: $result")
  }
}

class Person(name: String, age: Int) {
  def square(a: Int): Int = {
    a * a
  }
}