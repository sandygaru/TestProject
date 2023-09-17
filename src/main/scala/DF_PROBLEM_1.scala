
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, when}

object DF_PROBLEM_1 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("OOMExample").master("local[4]").getOrCreate()

    import spark.implicits._
    val df = List((10,"M"), (15,"F"), (20,"M"),(35,"F")).toDF("age", "gender")

    
    df.select(col("age"),col("gender"),
      when(col("age") >= 18,"TRUE").
        otherwise("FALSE").as("is_adult")).show()

    scala.io.StdIn.readLine()
  }
}
