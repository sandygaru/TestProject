
import org.apache.spark.sql
import org.apache.spark.sql.functions.{col, when}
import org.apache.spark.sql.types.{DoubleType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object DF_PROBLEM_15 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()

    // Define the schema for your DataFrame --> to handle null values
    val schema = StructType(
      List(
        StructField("timestamp", StringType, nullable = true)
      )
    )

    // Create a list with null values
    val data = List(
      ("2023-09-18 08:00:00"),
      ("2023-09-18 10:00:00"),
      ("2023-09-18 13:00:00"),
      ("2023-09-18 18:00:00"),
      ("2023-09-18 22:00:00")
    )
    // Convert the list to a list of Rows
    val rows = data.map {
      case ( temperature) => Row(temperature)
    }

    // Create a DataFrame with the specified schema
    val df = spark.createDataFrame(spark.sparkContext.parallelize(rows), schema)


    val splitdf = df.select(col("timestamp"),
      when(col("timestamp").contains(" "),sql.functions.split(col("timestamp")," ").getItem(1))
        .as("day_period")
        )


    val period = splitdf.select(col("timestamp"),
      when(col("day_period").contains(":"), sql.functions.split(col("day_period"), ":").getItem(0))
        .as("prd"))

    period.select(col("timestamp"),
      when(col("prd") >=4 && col("prd") <12,"Morning").
        when(col("prd") >=12 && col("prd") <16,"Afternoon").
        when(col("prd") >=16 && col("prd") <21,"Evening").
        otherwise("Night").as("day_period")
    ).show(false)

    scala.io.StdIn.readLine()
  }
}
