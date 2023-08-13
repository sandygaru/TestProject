class AccessModifiersExample {
  // Public member variable
  val publicVar: Int = 42

  // Private member variable
  private val privateVar: String = "Private variable"

  // Protected member variable
  protected val protectedVar: Double = 3.14

  // Public method
  def publicMethod(): Unit = {
    println("This is a public method.")
  }

  // Private method
  private def privateMethod(): Unit = {
    println("This is a private method.")
  }

  // Protected method
  protected def protectedMethod(): Unit = {
    println("This is a protected method.")
  }
}

class Subclass extends AccessModifiersExample {
  def accessProtectedVar(): Unit = {
    println(s"Accessing protected variable from subclass: $protectedVar")
  }

  def accessProtectedMethod(): Unit = {
    protectedMethod()
  }
}

object AccessModifiersDemo {
  def main(args: Array[String]): Unit = {
    val obj = new AccessModifiersExample()

    println(obj.publicVar)  // Accessible
     //println(obj.privateVar)  // Not accessible from outside the class
    // println(obj.protectedVar)  // Not accessible from outside the class

    obj.publicMethod()  // Accessible
    // obj.privateMethod()  // Not accessible from outside the class
    // obj.protectedMethod()  // Not accessible from outside the class

    val subObj = new Subclass()
    subObj.accessProtectedVar()  // Accessing protected variable from subclass
    subObj.accessProtectedMethod()  // This is a protected method.
  }
}