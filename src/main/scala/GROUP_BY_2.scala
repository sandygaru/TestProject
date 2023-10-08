//Finding the minimum, maximum, and average temperature for each city in a weather dataset.

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object GROUP_BY_2 {
  def main(args: Array[String]): Unit = {

    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()

    import spark.implicits._;
    val data = List((1, "ProductA", "Electronics", 2023, 1000.0)
    , (2, "ProductB", "Clothing", 2023, 500.0)
    , (3, "ProductC", "Electronics", 2022, 800.0)
    , (4, "ProductD", "Clothing", 2022, 300.0)
    , (5, "ProductE", "Electronics", 2023, 1200.0)).toDF("ID", "Product", "Category","year","Sales")

    //the total sales revenue for each product category and each year from the given Dat
    //aFrame, assuming there is a "year" column in the DataFrame

    val tot_sales = data.groupBy(col("Category"),col("year")).agg(sum(col("Sales")).alias("total_revenue"))

    tot_sales.show()

    //the product with the highest sales in each product category

    /*val maxSalesPerCategory = data.groupBy("Category")
      .agg(
        max("Sales").alias("MaxSales"),
        first("Product").alias("ProductWithMaxSales")   //shows wrong product for max sales
      )

    maxSalesPerCategory.show()*/


    // Group by Category and find the product with the highest sales in each category
    val maxSalesPerCategory = data.groupBy("Category")
      .agg(
        max("Sales").alias("MaxSales")
      )

    // Join the result back with the original DataFrame to get the corresponding product
    val result = data.join(maxSalesPerCategory, Seq("Category"), "inner")
      .filter(col("Sales") === col("MaxSales"))
      .select("Category", "Product", "MaxSales")

    result.show()

  }
}
