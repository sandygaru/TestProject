import org.apache.spark.SparkContext

object dagDemo {
  def main(args: Array[String]): Unit = {

    // Create Spark configuration
    val sc = new SparkContext("local[8]", "santhosh")

    val input=sc.textFile("C:/Users/saisa/OneDrive/Documents/SPARK_SCALA/test_file.txt");

    val words=input.flatMap(x=>x.split((" ")))

    val wordsmap=words.map(x=>(x,1))

    wordsmap.collect.foreach(println)
    scala.io.StdIn.readLine()

  }
}