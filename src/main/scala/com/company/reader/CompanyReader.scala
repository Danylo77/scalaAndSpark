package com.company.reader

import com.company.common.{PipelineData, PipelineStep}
import com.company.config.CompanyConfig

class CompanyReader(cf: CompanyConfig) extends PipelineStep {

  override def process(sd: PipelineData): PipelineData = {

    val source = scala.io.Source.fromFile(cf.filepath)
    try {
      val lines = source.getLines().toList
      val dataLines = lines.tail
      val companies: Seq[CompanyRow] = dataLines.map { line =>
        val Array(name, revenueStr, employeesStr) = line.split(",").map(_.trim)
        CompanyRow(name, revenueStr.toLong, employeesStr.toInt)
      }

      sd.add(CompanyRowTable, companies)
    } catch {
      case ex: Exception =>
        throw new RuntimeException(s"Failed to read file ${cf.filepath}: ${ex.getMessage}", ex)
    } finally {
      source.close()
    }
  }
}