package com.company.common

import org.apache.spark.sql.SparkSession

trait PipelineStep {
  def process(sd: SparkData)(implicit spark: SparkSession): SparkData
}