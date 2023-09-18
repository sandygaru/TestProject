
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, when}

object DF_PROBLEM_7 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()


    // Create a list with null values
    import spark.implicits._
    val df = List((2,100,50), (1,25,0), (3,450,-70), (0,0, -9)).toDF("sales","expenses","profit")


    df.select(col("sales"),col("expenses"),col("profit"),
      when(col("profit") > 0 ,"Profitable").
      when(col("profit") ===0 ,"Break-even").
        when(col("profit") < 1 && col("sales") > 0 ,"Loss-making").
        when(col("profit") < 1 && col("sales") === 0,"No Sales").as("profit_status")
        ).show()

    scala.io.StdIn.readLine()
  }
}
