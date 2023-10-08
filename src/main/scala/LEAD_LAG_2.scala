//Finding the minimum, maximum, and average temperature for each city in a weather dataset.

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, lag, when}

object LEAD_LAG_2 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession
    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()
    import spark.implicits._;
    val data = List(
      (1, "John", 1000, "2021-01-01"),
      (1, "John", 2000, "2021-01-02"),
      (1, "John", 1000, "2021-01-03"),
      (1, "John", 2000, "2021-01-04"),
      (1, "John", 3000, "2021-01-05"),
      (1, "John", 1000, "2021-01-06")
    ).toDF("ID", "NAME", "SALARY","DATE")

    // If salary is less than previous month we will mark it as "DOWN", if salary has increased then "UP"

    val windowspec = Window.orderBy("DATE")

    val df = data.withColumn("sal_diff", col("SALARY") - lag("SALARY",1).over(windowspec))

    df.withColumn("sal_prev_check", when($"sal_diff" < 0, "DOWN" ).otherwise("UP")).show()


  }
}
