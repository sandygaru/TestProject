import org.apache.spark.SparkContext
import org.apache.spark.sql.{SaveMode, SparkSession}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object SparkSampleCode {
  def main(args: Array[String]): Unit = {
    // Create Spark configuration
   /* val sc = new SparkContext("local[8]", "santhosh")

    val input = sc.textFile("C:/Users/saisa/OneDrive/Documents/SPARK_SCALA/test_file.txt");

    val words = input.flatMap(x => x.split((" ")))

    val wordsmap = words.map(x => (x, 1))

    val reducewords = wordsmap.reduceByKey((x, y) => (x + y))

    val sortresult = reducewords.sortBy(x => x._2, false)

    sortresult.take(1).foreach(println)  //limiting the records
    // sortresult.collect.foreach(println)
    scala.io.StdIn.readLine()*/

    val spark = SparkSession.builder.appName("OOMExample").master("local[4]").getOrCreate()


    val schema = StructType(
      List(
        StructField("name", StringType),
        StructField("age", IntegerType),
        StructField("city", StringType) // Assuming "age" is an integer
      )
    )

    val df = spark.read
      .format("csv")
      .option("header", true)
      .schema(schema)
      .option("mode","FAILFAST")
      .option("path", "C:/Users/saisa/OneDrive/Documents/SPARK_SCALA/info1.csv")
      .load()

    df.show()
    df.printSchema()

    df.write
      .format("csv")
      .mode(SaveMode.Ignore)
      //      .bucketBy(4,"city")
      .option("path", "C:/Users/saisa/OneDrive/Documents/SPARK_SCALA/output")
      .save()


    scala.io.StdIn.readLine()
  }
}
