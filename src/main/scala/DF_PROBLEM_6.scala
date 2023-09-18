
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.catalyst.expressions.CurrentRow.nullable
import org.apache.spark.sql.functions.{col, when}
import org.apache.spark.sql.types.{IntegerType, StructField, StructType}

object DF_PROBLEM_6 {
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

    val data = List((1,5,500), (2,1,85), (null,1,85), (2,-8,85), (2,1,-99))


    // Convert the list to a list of Rows
    val rows = data.map {
      case (product_id, quantity,price) => Row(product_id, quantity,price)
    }

    // Create a DataFrame with the specified schema
    val df = spark.createDataFrame(spark.sparkContext.parallelize(rows), schema)

    df.select(col("product_id"),col("quantity"),col("price"),
      when(col("product_id").isNull || col("quantity") < 1 || col("price") <1 ,
        0).
        otherwise(col("quantity") * col("price"))
      .as("revenue")
        ).show()

    scala.io.StdIn.readLine()
  }
}
