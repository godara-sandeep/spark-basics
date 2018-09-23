package org.sandeepgodara.spark.stream

import org.apache.spark.sql.SparkSession

object Application {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder
      .appName("SocketWordCount")
      .getOrCreate()
    new SocketStreamProcessor(spark)
  }
}
