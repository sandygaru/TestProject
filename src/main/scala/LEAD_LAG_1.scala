
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, lag}

object LEAD_LAG_1 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession
    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()
    import spark.implicits._;
    val data = List(
      (1, "KitKat", 1000.0, "2021-01-01"),
      (1, "KitKat", 2000.0, "2021-01-02"),
      (1, "KitKat", 1000.0, "2021-01-03"),
      (1, "KitKat", 2000.0, "2021-01-04"),
      (1, "KitKat", 3000.0, "2021-01-05"),
      (1, "KitKat", 1000.0, "2021-01-06")
    ).toDF("IT_ID", "IT_Name", "Price","PriceDate")

    // we want to find the difference between the price on each day with it’s previous day

    val windowspec = Window.orderBy("PriceDate")

    val df = data.withColumn("price_diff", col("Price") - lag("Price",1).over(windowspec))

    df.show()

  }
}
