
import org.apache.spark.sql.functions.{col, lit, when}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object DF_PROBLEM_16 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()

    // Define the schema for your DataFrame --> to handle null values
    val schema = StructType(
      List(
        StructField("user_id", IntegerType, nullable = true),
        StructField("subscription_date", StringType, nullable = true)
      )
    )

    // Create a list with null values
    val data1 = List((25, "2016-09-30"), (35, "2017-09-30"), (40, "2018-09-30"))

    val data2 = List((25, "2019-09-30"), (45, "2020-09-30"), (40, "2021-09-30"))

    // Convert the list to a list of Rows
    val rows1 = data1.map {
      case (user_id, subscription_date) => Row(user_id, subscription_date)
    }

    val rows2 = data1.map {
      case (user_id, subscription_date) => Row(user_id, subscription_date)
    }

    // Create a DataFrame with the specified schema
    val df1 = spark.createDataFrame(spark.sparkContext.parallelize(rows1), schema)

    val df2 = spark.createDataFrame(spark.sparkContext.parallelize(rows2), schema)

    df1.select(col("user_id"),col("subscription_date"),lit("df1").as("DF_1")).show()

    df2.select(col("user_id"), col("subscription_date"), lit("df2").as("DF_2")).show()

    val df3 = df2.intersect(df1)

    df3.show()

    /*df.select(col("age"),col("income"),
      when(col("age").isNull,"Unknown").
      when(col("age") < 30,"Young").
        when(col("age") >= 30 && col("age") < 60 ,"Adult").
        when(col("age") > 60,"Senior").as("age_group")
        ).show()*/

    scala.io.StdIn.readLine()
  }
}
