//Finding the minimum, maximum, and average temperature for each city in a weather dataset.

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{avg, col, lag}

object lag_salary {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession
    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()
    import spark.implicits._;
    val data = List(
      (1, "Alice", 1000),
      (2, "Bob", 2000),
      (3, "Charlie", 1500),
      (4, "David", 3000)
    ).toDF("id1", "name", "salary")

    //Calculate the change in salary from the previous row to the current row, ordered by id

    val windowspec = Window.orderBy("id1")

    val df = data.withColumn("change_salary", col("salary") - lag("salary",1).over(windowspec))

    df.show()

  }
}
