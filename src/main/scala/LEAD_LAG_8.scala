

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, lag, lead, when}

object LEAD_LAG_8 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession
    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()
    import spark.implicits._;
    val data = List(
      (1, "Alice", 1000),
      (2, "Bob", 2000),
      (3, "Charlie", 1500),
      (4, "David", 3000),
      (5, "David", 5000)
    ).toDF("id1", "name", "salary")

    // Calculate the lead and lag of the salary column for each employee ordered by id, but only for the emplo
    //yees who have a salary greater than 1500

    val windowspec = Window.orderBy("id1").partitionBy("name")

    val lead_lag_sal = data
      .filter(col("salary") > 1500)
      .withColumn("lead_sal", lead("salary", 1).over(windowspec))
      .withColumn("lag_sal", lag("salary", 1).over(windowspec))

    lead_lag_sal.show()

  }
}
