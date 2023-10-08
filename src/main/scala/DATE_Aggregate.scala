//Finding the minimum, maximum, and average temperature for each city in a weather dataset.

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object DATE_Aggregate {
  def main(args: Array[String]): Unit = {

    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()

    import spark.implicits._;
    val df = Seq(("2023-10-07", null), (null, "2023-10-08")).toDF("date1", "date2")
    val filledDf = df.withColumn("date1", coalesce($"date1", lit("2023-01-01")))
      .withColumn("date2", when($"date2".isNull, lit("2023-12-31")).otherwise($"date2"))

    filledDf.show()

    val df1 = Seq(("2023-10-07", null), (null, "2023-10-08")).toDF("date1", "date2")
    df1.withColumn("date1", coalesce($"date1", lit("2023-01-01")))
      .withColumn("date2", when($"date2".isNull, lit("2023-12-31")).otherwise($"date2")).show()

    val df2 = Seq(("2023-10-07", "15:30:00")).toDF("date", "time")
    df2.withColumn("formatted_date", date_format($"date", "yyyy/MM/dd"))
      .withColumn("formatted_time", date_format($"time", "HH:mm:ss")).show()

    val df3 = Seq(("2023-10-07 15:30:00")).toDF("timestamp")
    df3.withColumn("year", year(col("timestamp")))
      .withColumn("month", month(col("timestamp")))
      .withColumn("day", dayofmonth(col("timestamp"))).show()


    //Given a DataFrame with date1 and date2 columns, handle missing date values
    //by filling them with default dates.
    val df4 = List(("2023-10-07", null), (null, "2023-10-08")).toDF("date1", "date2")
    val date = df4.withColumn("date1", coalesce($"date1", lit("0000-00-00")))
                      .withColumn("date2", coalesce($"date2", lit("0000-00-00")))

    date.show()

    //Given a DataFrame with a timestamp column, extract the day of the week for
    //each timestamp and display it as a new column.

    val df5 = List("2023-10-07 12:00:00", "2023-10-10 15:30:00").toDF("timestamp_str")
    df5.withColumn("day", dayofmonth(col("timestamp_str"))).show()


    //Calculate the number of days between a date column and the current date for
    //each row in the DataFrame.
    val df6 = List("2023-10-07", "2023-10-10", "2023-10-01").toDF("date_str")

    df6.withColumn("date_with_current_diff",datediff($"date_str",current_date())).show()

  }
}
