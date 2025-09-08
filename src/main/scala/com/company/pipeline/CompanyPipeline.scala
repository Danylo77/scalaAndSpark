package com.company.pipeline

import com.company.common.PipelineData
import com.company.config.CompanyConfig
import com.company.exporter.CompanyExporter
import com.company.processor.CompanyProcessor
import com.company.reader.CompanyReader

class CompanyPipeline(cf: CompanyConfig) {

  private val steps = Seq(
    new CompanyReader(cf),
    new CompanyProcessor(),
    new CompanyExporter()
  )

  def run(): Unit = {
    steps.foldLeft(PipelineData()) { (sd, step) =>
      step.process(sd)
    }
  }
}
