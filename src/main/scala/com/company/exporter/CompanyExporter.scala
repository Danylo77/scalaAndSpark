package com.company.exporter

import com.company.common.{PipelineStep, SparkData}
import com.company.processor.model.{CompanyModel, CompanyModelTable}
import org.apache.spark.sql.{Dataset, SparkSession}

class CompanyExporter extends PipelineStep {
  override def process(sd: SparkData)(implicit spark: SparkSession): SparkData = {
    import spark.implicits._
    val processed: Dataset[CompanyModel] = sd.getTable(CompanyModelTable)

    processed.show()

    val top = processed
      .toDF()
      .orderBy($"revenuePerEmployee".desc)
      .limit(1)
      .as[CompanyModel]
      .first()

    println(s"Top company: ${top.companyName} with revenue per employee = ${top.revenuePerEmployee}")

    sd
  }
}