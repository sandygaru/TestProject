trait TA {
  def show(): Unit = println("A")
}

trait TB extends TA {
  override def show(): Unit = println("B")
}

trait TC extends TA {
  override def show(): Unit = println("C")
}

class TD extends TB with TC {
  def showTD(): Unit = {
    show()  // 'C' is called due to linearization order
  }
}

object multipleDemo {
  def main(args: Array[String]): Unit = {

    val objtd=new TD();
    objtd.showTD()       //TC and then only it look for TB --> extends TB with TC
  }
}