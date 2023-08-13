// Base class
class Animal(val name: String) {
  def speak(): Unit = {
    println("An animal makes a sound")
  }
}

// Subclass inheriting from Animal
class Dog(name: String) extends Animal(name) {
  override def speak(): Unit = {
    println(s"$name barks: Woof woof!")
  }
}

// Subclass inheriting from Animal
class Cat(name: String) extends Animal(name) {
  override def speak(): Unit = {
    println(s"$name meows: Meow meow!")
  }
}

object InheritanceExample {
  def main(args: Array[String]): Unit = {
    val dog = new Dog("Buddy")
    val cat = new Cat("Whiskers")

    dog.speak() // Output: Buddy barks: Woof woof!
    cat.speak() // Output: Whiskers meows: Meow meow!
  }
}