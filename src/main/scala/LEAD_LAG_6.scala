
import org.apache.spark.sql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, lag, when}

object LEAD_LAG_6 {
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

    // Calculate the difference between the current salary and the minimum salary within the last three rows, o
    //rdered by id

    val windowspec = Window.orderBy("id1")

    val prev_sal_per = data
      .withColumn("PrevSalary1", lag( "salary", 3).over(windowspec))
      .withColumn("PrevSalary2", lag("salary", 2).over(windowspec))
      .withColumn("PrevSalary3", lag("salary", 1).over(windowspec))

    val min_prev_salary = prev_sal_per.withColumn("min_salary",
      when(col("PrevSalary1") <  col("PrevSalary2")  &&col("PrevSalary1") <  col("PrevSalary3"), $"PrevSalary1").
        when(col("PrevSalary2") <  col("PrevSalary1")  &&col("PrevSalary2") < col("PrevSalary3"), $"PrevSalary2").
        otherwise($"PrevSalary3")
    )

    min_prev_salary.withColumn("sal_diff",$"salary" - $"min_salary").show()

  }
}
