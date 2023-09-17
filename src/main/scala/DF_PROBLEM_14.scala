
import org.apache.spark.sql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, when}

object DF_PROBLEM_14 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("OOMExample").master("local[4]").getOrCreate()

    import spark.implicits._
    val df = List((10,2,500), (101,5,600), (250,10,90),(325,2,8)).toDF("product_id", "quantity", "price")

    
    df.select(col("product_id"),col("quantity"),col("price"),
      when(col("product_id") >= 1 && col("product_id") <= 100, col("quantity")*col("price")).
        when(col("product_id") >= 101 && col("product_id") <= 200, col("quantity")*col("price")*0.9).
        when(col("product_id") >= 201 && col("product_id") <= 300, col("quantity")*col("price")*0.8).
        otherwise(0).as("revenue")).show()

    scala.io.StdIn.readLine()
  }
}
