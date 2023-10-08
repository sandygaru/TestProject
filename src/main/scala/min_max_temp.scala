//Finding the minimum, maximum, and average temperature for each city in a weather dataset.

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{avg, col, count,min,max}

object min_max_temp {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()
    import spark.implicits._;
    val weatherData = List(
      ("City1", "2022-01-01", 10.0),
      ("City1", "2022-01-02", 8.5),
      ("City1", "2022-01-03", 12.3),
      ("City2", "2022-01-01", 15.2),
      ("City2", "2022-01-02", 14.1),
      ("City2", "2022-01-03", 16.8)
    ).toDF("City", "Date", "Temperature")

    //average rating for each movie
    //ratingsData.groupBy(col("Movie")).agg(avg(col("Rating")).alias("avg_rating")).show()

    //the minimum, maximum, and average temperature for each city in a weather dataset
    weatherData.groupBy(col("City")).agg(min(col("Temperature")).alias("min_temp")).show()
    weatherData.groupBy(col("City")).agg(max(col("Temperature")).alias("max_temp")).show()
    weatherData.groupBy(col("City")).agg(avg(col("Temperature")).alias("avg_temp")).show()



  }
}
