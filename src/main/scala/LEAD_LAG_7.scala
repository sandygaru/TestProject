

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, lag, lead, when}

object LEAD_LAG_7 {
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

    // Calculate the lead and lag of salary within each group of employees (grouped by name) ordered by id.

    val windowspec = Window.orderBy("id1").partitionBy("name")

    val lead_lag_sal = data
      .withColumn("lead_sal", lead( "salary", 1).over(windowspec))
      .withColumn("lag_sal", lag("salary", 1).over(windowspec))

    lead_lag_sal.show()

  }
}
