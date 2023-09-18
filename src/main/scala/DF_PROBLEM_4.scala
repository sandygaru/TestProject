
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.catalyst.expressions.CurrentRow.nullable
import org.apache.spark.sql.functions.{col, when}
import org.apache.spark.sql.types.{IntegerType, StructField, StructType}

object DF_PROBLEM_4 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()

    import spark.implicits._

    // Define the schema for your DataFrame --> to handle null values
    val schema = StructType(
      List(
        StructField("age", IntegerType, nullable = true),
        StructField("income", IntegerType, nullable = true)
      )
    )

    // Create a list with null values
    val data = List((25, 25000), (35, 47500), (40, 80000), (null, 70000), (70, 30000), (10, 54632))

    // Convert the list to a list of Rows
    val rows = data.map {
      case (age, income) => Row(age, income)
    }

    // Create a DataFrame with the specified schema
    val df = spark.createDataFrame(spark.sparkContext.parallelize(rows), schema)


    df.select(col("age"),col("income"),
      when(col("age").isNull,"Unknown").
      when(col("age") < 30,"Young").
        when(col("age") >= 30 && col("age") < 60 ,"Adult").
        when(col("age") > 60,"Senior").as("age_group")
        ).show()

    scala.io.StdIn.readLine()
  }
}
