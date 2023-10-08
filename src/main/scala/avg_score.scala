

import org.apache.spark.sql
import org.apache.spark.sql.functions.{avg,max, col, when}
import org.apache.spark.sql.types.{DoubleType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object avg_score {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()
    import spark.implicits._;
    val scoreData = List(
      ("Alice", "Math", 80),
      ("Bob", "Math", 90),
      ("Alice", "Science", 70),
      ("Bob", "Science", 85),
      ("Alice", "English", 75),
      ("Bob", "English", 95)
    ).toDF("Student", "Subject", "Score")

    //Finding the average score for each subject and the maximum score for each student.
    scoreData.groupBy(col("Subject")).agg(avg(col("Score"))).show()

    scoreData.groupBy(col("Student")).agg(max(col("Score"))).show()

  }
}
