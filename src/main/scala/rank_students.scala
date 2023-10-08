//Finding the minimum, maximum, and average temperature for each city in a weather dataset.

import org.apache.spark.sql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, desc}

object rank_students {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession
    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()
    import spark.implicits._;
    val data = List(
      ("Math", "Alice", 90),
      ("Math", "Bob", 85),
      ("Math", "Carol", 92),
      ("Science", "Alice", 78),
      ("Science", "Bob", 88),
      ("Science", "Carol", 82)
    ).toDF("Subject", "Student", "Score")

    //Calculate Rank of Students within Each Subject

    val windowspec = Window.partitionBy("Subject").orderBy(desc("Score"))

    //top 1

    val df = data.withColumn("rank-students",sql.functions.rank().over(windowspec)).filter(col("rank-students") <= 1)

    df.show()

  }
}
