import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, when}

object DF_sample {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("OOMExample").master("local[4]").getOrCreate()

    import spark.implicits._;
    val df = List(("Alice", 25), ("Bob", 30), ("Charlie", 35)).toDF("name", "age")
    val categorizedDF = df.select(col("name"), col("age"), when(col("age") < 30, "Young").otherwise("Old").alias("category"))
    categorizedDF.show()

    val df1 = List(("Alice", 25), ("Bob", 30), ("Charlie", 35)).toDF("name", "age")
    df1.filter(col("age") > 30).show()

    val df2 = List(("Alice", 25), ("Bob", 30), ("Charlie", 35)).toDF("name", "age")
    val filteredDF = df2.filter(col("age") >= 25 && col("name").startsWith("A"))
    filteredDF.show()

    scala.io.StdIn.readLine()
  }
}