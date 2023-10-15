
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, lag}

object LEAD_LAG_5 {
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

    // Calculate the percentage change in salary from the previous row to the current row, ordered by id.

    val windowspec = Window.orderBy("id1")

    val prev_sal_per = data.withColumn("PrevSalary1", lag("salary", 2).over(windowspec))
      .withColumn("PrevSalary2", lag("salary", 1).over(windowspec))

    prev_sal_per.withColumn("prev_2_salary", $"PrevSalary1" + $"PrevSalary2").show()

  }
}
