//Finding the minimum, maximum, and average temperature for each city in a weather dataset.

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object GROUP_BY_3 {
  def main(args: Array[String]): Unit = {

    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()

    import spark.implicits._;
    val df = {
    List((1, "ProductA", "Electronics", "2023-01-15", 1000.0)
    ,
    (2, "ProductB", "Clothing", "2023-02-20", 500.0)
    ,
    (3, "ProductC", "Electronics", "2023-04-10", 800.0)
    ,
    (4, "ProductD", "Clothing", "2023-05-05", 300.0)
    ,
    (5, "ProductE", "Electronics", "2023-01-25", 1200.0)
    ).toDF("ID", "Product", "Category", "Date", "Revenue")
    }

    //the total sales revenue for each product category and each   of the year from
    //the given DataFrame, assuming there is a "date" column containing dates in the format ’yyyy-MM-dd’

    // Convert the "Date" column to a timestamp
    val dateFmt = "yyyy-MM-dd"
    val dfWithTimestamp = df.withColumn("Date", to_timestamp(col("Date"), dateFmt))

    // Extract the quarter and year from the date
    val dfWithQuarterYear = dfWithTimestamp.withColumn("Quarter", quarter(col("Date")))
      .withColumn("Year", year(col("Date")))

    // Group the DataFrame by category, quarter, and year and calculate the total revenue
    val result = dfWithQuarterYear.groupBy("Category", "Quarter", "Year")
      .agg(sum("Revenue").alias("TotalRevenue"))

    // Show the result
    result.show()

  }
}
