
import org.apache.spark.sql
import org.apache.spark.sql.functions.{col, when}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object DF_PROBLEM_8 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()

    // Define the schema for your DataFrame --> to handle null values
    val schema = StructType(
      List(
        StructField("first_name", StringType, nullable = true),
        StructField("last_name", StringType, nullable = true)
      )
    )

    // Create a list with null values
    val data = List(("santhosh","sandy"),("kar","inban"),("kaaruyan",null),(null,"kapoor"))

    // Convert the list to a list of Rows
    val rows = data.map {
      case (first_name, last_name) => Row(first_name, last_name)
    }

    // Create a DataFrame with the specified schema
    val df = spark.createDataFrame(spark.sparkContext.parallelize(rows), schema)


    df.select(col("first_name"),col("last_name"),
      when(col("first_name").isNull || col("last_name").isNull ,"Unknown").
        otherwise(sql.functions.concat_ws(" ",col("first_name"),col("last_name"))).as("full_name")
        ).show()

    scala.io.StdIn.readLine()
  }
}
