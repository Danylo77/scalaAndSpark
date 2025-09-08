package com.company.processor

import com.company.common.{PipelineStep, SparkData}
import com.company.processor.model.{CompanyModel, CompanyModelTable}
import com.company.reader.CompanyRowTable
import org.apache.spark.sql.{Dataset, SparkSession}

class CompanyProcessor extends PipelineStep {

  override def process(sd: SparkData)(implicit spark: SparkSession): SparkData = {
    import spark.implicits._
    val companyRowDS = sd.getTable(CompanyRowTable)

    val processed: Dataset[CompanyModel] = companyRowDS
      .filter($"employees" >= 50)
      .withColumn("revenuePerEmployee", $"revenue" / $"employees")
      .as[CompanyModel]

    sd.add(CompanyModelTable, processed)
  }

}

