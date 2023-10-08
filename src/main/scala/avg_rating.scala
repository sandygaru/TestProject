//Finding the average score for each subject and the maximum score for each student.

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{avg,count, col, max}

object avg_rating {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()
    import spark.implicits._;
    val ratingsData = List(
      ("User1", "Movie1", 4.5),
      ("User2", "Movie1", 3.5),
      ("User3", "Movie2", 2.5),
      ("User4", "Movie2", 3.0),
      ("User1", "Movie3", 5.0),
      ("User2", "Movie3", 4.0)
    ).toDF("User", "Movie", "Rating")

    //average rating for each movie
    ratingsData.groupBy(col("Movie")).agg(avg(col("Rating")).alias("avg_rating")).show()

    //total number of ratings for each movie
    ratingsData.groupBy(col("Movie")).agg(count(col("Rating")).alias("total_rating")).show()


  }
}
