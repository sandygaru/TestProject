import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, when}

object DF_PROBLEM_10 {

  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()


    // Create a list with null values
    import spark.implicits._
    val df = List((20, 65916), (35, 65323), (75, 78456), (14, 30000), (96, 653)).toDF("age", "income")


    df.select(col("age"), col("income"),
      when(col("age") <25 && col("income") >= 50000 , "Young High-Income").
        when(col("age") >= 25 && col("age") >= 60 && col("income") >= 50000, "Middle-Aged High-Income").
        when(col("age") >60 && col("income") >= 50000 , "Senior High-Income").
       otherwise("Other").as("customer_type")
    ).show(false)

    scala.io.StdIn.readLine()
  }
}
