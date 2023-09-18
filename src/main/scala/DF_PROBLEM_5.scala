
import org.apache.spark.sql.functions.{col, when}
import org.apache.spark.sql.types.{IntegerType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object DF_PROBLEM_5 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()


    // Create a list with null values
    import spark.implicits._
    val df = List((25.5,60), (31.2,66), (25.6, 26), (35.6, 10)).toDF("temperature","humidity")


    df.select(col("temperature"),col("humidity"),
      when(col("temperature") >= 30 && col("humidity") >=60 ,"Hot and Humid").
      when(col("temperature") < 30 && col("humidity") >=60,"Warm and Humid").
        when(col("temperature") >= 30 && col("humidity") <60 ,"Hot and Dry").
        when(col("temperature") < 30 && col("humidity") <60,"Moderate").as("weather_type")
        ).show()

    scala.io.StdIn.readLine()
  }
}
