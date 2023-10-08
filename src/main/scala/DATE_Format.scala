//Finding the minimum, maximum, and average temperature for each city in a weather dataset.

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object DATE_Format {
  def main(args: Array[String]): Unit = {

    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()

    import spark.implicits._;
    val df = List(("2023-10-07", "15:30:00")).toDF("date_str", "time_str")
    val formattedDf = df.withColumn("date", to_date($"date_str"))
      .withColumn("time", to_timestamp($"time_str"))

    formattedDf.show()

    formattedDf.printSchema()

    val df1 = List(("2023-10-07", "2023-10-10")).toDF("date1", "date2")
    df1.withColumn("days_diff", datediff($"date2", $"date1")).show()

    df1.withColumn("days_add", date_add( $"date1",1)).show()

    df1.withColumn("days_sub", date_sub( $"date1",1)).show()

    df1.withColumn("add_months", add_months( $"date1",2)).show()

    //Calculate the number of days between two dates using Spark SQL
    val df2 = List(("2023-10-07", "2023-10-10")).toDF("date1", "date2")
    df2.withColumn("days_diff", datediff($"date2", $"date1")).show()

  }
}
