
import org.apache.spark.sql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, when}

object DF_PROBLEM_13 {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession

    val spark = SparkSession.builder.appName("OOMExample").master("local[4]").getOrCreate()

    import spark.implicits._
    val df = List(("santhosh29498@gmail.com"), ("saisanthosh@outlook.com"), null,("kaarun")).toDF("email")




    df.select(col("email"),
      when(col("email").isNull, "Unknown")
      .when(col("email").contains("@"), sql.functions.split(col("email"),"@").getItem(0))
        .otherwise("Unknown").as("username") ,
      when(col("email").isNull, "Unknown")
      .when(col("email").contains("@"),sql.functions.split(col("email"),"@").getItem(1))
        .otherwise("Unknown").as("domain")).show()

    scala.io.StdIn.readLine()
  }
}
