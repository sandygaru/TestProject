

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, lag, lead}

object LEAD_LAG_9 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession
    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()
    import spark.implicits._;
    val data = List(
      (1, "Alice", 1000),
      (2, "Bob", 2000),
      (3, "Charlie", 1500),
      (4, "Charlie", 1500),
      (5, "David", 3000),
      (6, "David", 5000)
    ).toDF("id1", "name", "salary")

    // Calculate the lead and lag of the salary column for each employee, ordered by id, but only for the emplo
    //yees who have a change in salary greater than 500 from the previous row.

    val windowspec = Window.orderBy("id1").partitionBy("name")

    val lag_sal = data
      .withColumn("lag_sal", lag("salary", 1).over(windowspec))

    lag_sal.filter((col("salary") - col("lag_sal")) > 500).show()

  }
}
