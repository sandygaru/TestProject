//Finding the minimum, maximum, and average temperature for each city in a weather dataset.

import org.apache.spark.sql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{desc, rank}

object rank {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession
    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()
    import spark.implicits._;
    val data = List(
      ("Electronics", "Laptop", 2000),
      ("Electronics", "Phone", 1500),
      ("Electronics", "Tablet", 1200),
      ("Clothing", "Shirt", 800),
      ("Clothing", "Jeans", 1000),
      ("Clothing", "Dress", 1000)
    ).toDF("Category", "Product", "SalesAmount")

    //average rating for each movie
    //ratingsData.groupBy(col("Movie")).agg(avg(col("Rating")).alias("avg_rating")).show()

    val windowspec = Window.partitionBy("Category").orderBy(desc("SalesAmount"))

    data.withColumn("top-2",sql.functions.rank().over(windowspec)).show()
  }
}
