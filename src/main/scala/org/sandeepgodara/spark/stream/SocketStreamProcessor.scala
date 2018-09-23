package org.sandeepgodara.spark.stream

import org.apache.spark.sql.SparkSession

class SocketStreamProcessor(spark: SparkSession) {

  def start ={
    import spark.implicits._
    val lineStream$ = spark.readStream
      .format("socket")
      .option("host", "localhost")
      .option("port", 9999)
      .load()
    val wordsDS = lineStream$.as[String].flatMap(_.split(" "))
    val wordCount = wordsDS.groupBy($"value").count()
    val query = wordCount.writeStream
      .format("console")
      .outputMode("complete")
      .start()
    query.awaitTermination()
  }

}
