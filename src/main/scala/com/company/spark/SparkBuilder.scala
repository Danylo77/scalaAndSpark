package com.company.spark

import org.apache.spark.sql.SparkSession

object SparkBuilder {
  def build(): SparkSession = {
    SparkSession.builder()
      .appName("CompanyPipelineApp")
      .master("local[*]")
      .getOrCreate()
  }
}
