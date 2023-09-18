import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.ScalaReflection.universe.show
import org.apache.spark.sql.functions.{col, when}

object DF_PROBLEM_9 {

  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()


    // Create a list with null values
    import spark.implicits._
    val df = List((20, 10), (10, 10), (10, 0), (10, 30), (-99, -99)).toDF("sales", "expenses")


    df.select(col("sales"), col("expenses"),
      when(col("sales") > 0 && col("expenses") > 0 && col("sales") > col("expenses"), "Profitable").
        when(col("sales") > 0 && col("expenses") > 0 && col("sales") === col("expenses"), "Break-even").
        when(col("sales") > 0 && col("expenses") === 0, "No Expenses").
        when(col("sales") > 0 && col("expenses") > 0 && col("expenses") > col("sales"), "Loss-making").
        otherwise("Unknown").as("profit_status")
    ).show()

    scala.io.StdIn.readLine()
  }
}
