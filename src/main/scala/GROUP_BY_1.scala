//Finding the minimum, maximum, and average temperature for each city in a weather dataset.

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{avg, col, desc, max, min, sum}

object GROUP_BY_1 {
  def main(args: Array[String]): Unit = {

    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()

    import spark.implicits._;
    val data = List((1, "ProductA", "Electronics", 1000.0)
    , (2, "ProductB", "Clothing", 500.0)
    , (3, "ProductC", "Electronics", 800.0)
    , (4, "ProductD", "Clothing", 300.0)
    , (5, "ProductE", "Electronics", 1200.0)).toDF("ID", "Product", "Category","Sales")

    // Calculate the total sales revenue for each product category

    val tot_sales = data.groupBy(col("Category")).agg(sum(col("Sales")).alias("total_revenue"))

    tot_sales.show()

    //the average sales price for each product category and display the result in descending order of average price

    val df = data.groupBy(col("Category")).agg(avg(col("Sales")).alias("avg_price"))

    df.sort(col("avg_price").desc).show()

    //the total sales revenue for each product category, and also find the category with the highest total sales

    tot_sales.sort(col("total_revenue").desc).show(1)

    //minimum and maximum sales values for each product category

    data.groupBy(col("Category")).agg(min(col("Sales")).alias("min_revenue")).show()

    data.groupBy(col("Category")).agg(max(col("Sales")).alias("max_revenue")).show()

    //the average sales price for each product category and add a new column to the DataFrame with the calculated average

    df.show()



  }
}
