import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, when}

object DF_sample {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("OOMExample").master("local[4]").getOrCreate()

    import spark.implicits._
    val df = List(("john", 25, "hyd"), ("meera", 18, "chen"), ("sudha", 10, "mum"), ("jone", 45, "hyd"), ("mira", 67, "hyd")).toDF("name", "age", "city")


    df.select(col("name"), col("age"),
      when(col("age") > 40 && col("age") <= 70, "OLD")
        .when(col("age") > 20 && col("age") < 30, "adult")
        .otherwise("young").as("category"), col("city")).show()


    scala.io.StdIn.readLine()
  }
}