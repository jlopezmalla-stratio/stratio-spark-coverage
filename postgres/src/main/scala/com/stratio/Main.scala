package com.stratio


import Outputs.PostgresOutput
import org.apache.spark._
import org.apache.spark.sql.SparkSession

object Main {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .appName("Postgres_ATJob")
      .getOrCreate()

    import spark.implicits._
    val df = spark.sparkContext.parallelize(List(1,2,3,4,5,6,7,8,9,10)).toDF("numbers")
    PostgresOutput(spark, args(1), args(2), args(3), args(4), None).saveWithoutKeyAndTrust(df)

  }
}
