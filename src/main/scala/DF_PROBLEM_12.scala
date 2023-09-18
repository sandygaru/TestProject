
import org.apache.spark.sql.functions.{col, when}
import org.apache.spark.sql.types.{DoubleType, IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object DF_PROBLEM_12 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()

    // Define the schema for your DataFrame --> to handle null values
    val schema = StructType(
      List(
        StructField("timestamp", StringType, nullable = true),
        StructField("temperature", DoubleType, nullable = true),
        StructField("humidity", DoubleType, nullable = true)
      )
    )

    // Create a list with null values
    val data = List(
      ("2023-09-18 08:00:00", -25.5, 90.0),
      ("2023-09-18 09:00:00", 7.0, 75.5),
      ("2023-09-18 10:00:00", 26.5, 57.0),
      ("2023-09-18 11:00:00", 27.0, 45.5),
      ("2023-09-18 12:00:00", 27.5, 80.0)
    )
    // Convert the list to a list of Rows
    val rows = data.map {
      case (timestamp, temperature, humidity) => Row(timestamp, temperature, humidity)
    }

    // Create a DataFrame with the specified schema
    val df = spark.createDataFrame(spark.sparkContext.parallelize(rows), schema)


    df.select(col("timestamp"),col("temperature"),col("humidity"),
      when(col("temperature") < 0 && col("humidity") > 80 , "Extreme Cold and Humid").
        when(col("temperature") >= 0 && col("temperature") <= 10
          && col("humidity") >= 50 && col("humidity") <= 80 ,"Cold and Moderate Humidity").
        when(col("temperature") > 10 && col("humidity") < 50, "Warm and Dry").
        otherwise("Other").as("weather_condition")
        ).show(false)

    scala.io.StdIn.readLine()
  }
}
