package com.company.reader

import com.company.common.{PipelineStep, SparkData}
import com.company.config.CompanyConfig
import org.apache.spark.sql.{Dataset, SparkSession}

class CompanyReader(cf: CompanyConfig) extends PipelineStep {

  override def process(sd: SparkData)(implicit spark: SparkSession): SparkData = {
    import spark.implicits._

    val ds: Dataset[CompanyRow] = spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(cf.filepath)
      .as[CompanyRow]

    sd.add(CompanyRowTable, ds)
  }
}