//Finding the minimum, maximum, and average temperature for each city in a weather dataset.

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{avg, col, max, min}

object window_funtion {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()
    import spark.implicits._;
    val ratingData = List(
      ("User1", "Movie1", 4.5),
      ("User1", "Movie2", 3.5),
      ("User1", "Movie3", 2.5),
      ("User1", "Movie4", 4.0),
      ("User1", "Movie5", 3.0),
      ("User1", "Movie6", 4.5),
      ("User2", "Movie1", 3.0),
      ("User2", "Movie2", 4.0),
      ("User2", "Movie3", 4.5),
      ("User2", "Movie4", 3.5),
      ("User2", "Movie5", 4.0),
      ("User2", "Movie6", 3.5)
    ).toDF("User", "Movie", "Rating")

  val windowspec = Window.partitionBy("Movie")

  val data = ratingData.withColumn("avg_rating",avg(col("Rating")).over(windowspec))

    data.show()

  }
}
