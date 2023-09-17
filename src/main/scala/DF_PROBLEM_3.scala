
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, when}

object DF_PROBLEM_3 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("OOMExample").master("local[4]").getOrCreate()

    import spark.implicits._
    val df = List((25000), (47500), (80000),(70000),(30000)).toDF("income")

    
    df.select(col("income"),
      when(col("income") < 30000,"Low").
        when(col("income") >= 30000 && col("income") < 70000 ,"Medium").
        otherwise("High").as("Category")).show()

    scala.io.StdIn.readLine()
  }
}
