import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.broadcast

object JOIN {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.appName("sandy").master("local").getOrCreate()

    val df1 = spark.read
      .format("csv")
      .option("header", true)
      .option("path", "C:/Users/saisa/data/seekho.txt")
      .load()


    val df2 = spark.read
      .format("csv")
      .option("header", true)
      .option("path", "C:/Users/saisa/data/EmployeeDetails.csv")
      .load()

    val conditionType = "inner"

    val condition = df1.col("id") === df2.col("id")

    val joinedDf = df2.join(broadcast(df1), condition, conditionType)

    joinedDf.show()
  }
}
