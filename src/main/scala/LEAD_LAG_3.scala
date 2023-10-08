//Finding the minimum, maximum, and average temperature for each city in a weather dataset.

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, lag, lead, when}

object LEAD_LAG_3 {
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

    // Calculate the lead and lag of the salary column ordered by id

    val windowspec = Window.orderBy("id1")

    val df = data.withColumn("lead",  lead("SALARY",1).over(windowspec))
      .withColumn("lag", lag("SALARY",1).over(windowspec))

    df.show()

  }
}
