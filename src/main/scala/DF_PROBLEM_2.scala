
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, when}

object DF_PROBLEM_2 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("OOMExample").master("local[4]").getOrCreate()

    import spark.implicits._
    val df = List((65,"Tamil"), (70,"English"), (80,"Maths"),(99,"Science"),(90,"Social Science")).toDF("score", "subject")

    
    df.select(col("score"),col("subject"),
      when(col("score") >= 90,"A").
        when(col("score") >= 70 && col("score") <90 ,"B").
        otherwise("C").as("grade")).show()

    scala.io.StdIn.readLine()
  }
}
