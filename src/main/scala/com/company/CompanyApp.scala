package com.company

import com.company.config.CompanyConfigLoader
import com.company.pipeline.CompanyPipeline
import com.company.spark.SparkBuilder
import org.apache.spark.sql.SparkSession

object CompanyApp {
  def main(args: Array[String]): Unit = {
    implicit val spark: SparkSession = SparkBuilder.build()

    val config = CompanyConfigLoader.load()

    val pipeline = new CompanyPipeline(config)
    pipeline.run()

    spark.stop()
  }
}
