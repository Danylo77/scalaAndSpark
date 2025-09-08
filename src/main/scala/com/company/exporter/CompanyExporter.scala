package com.company.exporter

import com.company.common.{PipelineData, PipelineStep}
import com.company.processor.model.CompanyModelTable

class CompanyExporter extends PipelineStep {
  override def process(sd: PipelineData): PipelineData = {
    val processed = sd.getTable(CompanyModelTable)

    processed.foreach(println(_))

    println("------")
    println(processed.maxBy(_.revenuePerEmployee))

    sd
  }
}