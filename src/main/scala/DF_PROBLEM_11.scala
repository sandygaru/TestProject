
import org.apache.spark.sql.functions.{col, when}
import org.apache.spark.sql.types.{IntegerType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object DF_PROBLEM_11 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()

    // Define the schema for your DataFrame --> to handle null values
    val schema = StructType(
      List(
        StructField("product_id", IntegerType, nullable = true),
        StructField("quantity", IntegerType, nullable = true),
        StructField("price", IntegerType, nullable = true)
      )
    )

    // Create a list with null values
    val data = List((25, 2,200), (35, 3,100), (null,2, 80000), (2,null, 70000), (3,70, null), (5,-86, 54632), (5,86, -99), (-99,86, 66626))

    // Convert the list to a list of Rows
    val rows = data.map {
      case (product_id, quantity, price) => Row(product_id, quantity, price)
    }

    // Create a DataFrame with the specified schema
    val df = spark.createDataFrame(spark.sparkContext.parallelize(rows), schema)


    df.select(col("product_id"),col("quantity"),col("price"),
      when(col("product_id").isNull,-1).
      when(col("quantity").isNull || col("price").isNull
        || col("product_id") < 1 || col("quantity") < 1 || col("price") < 1 ,0).
        otherwise(col("quantity")*col("price")).as("revenue")
        ).show()

    scala.io.StdIn.readLine()
  }
}
