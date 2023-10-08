//Finding the minimum, maximum, and average temperature for each city in a weather dataset.

import org.apache.spark.sql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{avg, col, desc}

object moving_avg_temp {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession
    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()
    import spark.implicits._;
    val data = List(
      ("New York", "2023-01-01", 32),
      ("New York", "2023-01-02", 34),
      ("New York", "2023-01-03", 30),
      ("Chicago", "2023-01-01", 25),
      ("Chicago", "2023-01-02", 28),
      ("Chicago", "2023-01-03", 22)
    ).toDF("Location", "Date", "Temperature")

    //Calculate Moving Average of Temperature

    val windowspec = Window.partitionBy("Location").orderBy("Temperature")

    val df = data.withColumn("moving_avg", avg(col("Temperature")).over(windowspec))

    df.show()

  }
}
