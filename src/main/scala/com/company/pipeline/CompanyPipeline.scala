package com.company.pipeline

import com.company.common.SparkData
import com.company.config.CompanyConfig
import com.company.exporter.CompanyExporter
import com.company.processor.CompanyProcessor
import com.company.reader.CompanyReader
import org.apache.spark.sql.SparkSession

class CompanyPipeline(cf: CompanyConfig)(implicit spark: SparkSession) {

  private val steps = Seq(
    new CompanyReader(cf),
    new CompanyProcessor(),
    new CompanyExporter()
  )

  def run(): Unit = {
    steps.foldLeft(SparkData()) { (sd, step) =>
      step.process(sd)
    }
  }
}
