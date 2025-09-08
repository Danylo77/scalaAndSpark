package com.company.processor

import com.company.common.{PipelineStep, PipelineData}
import com.company.processor.model.{CompanyModel, CompanyModelTable}
import com.company.reader.CompanyRowTable

class CompanyProcessor extends PipelineStep {

  override def process(sd: PipelineData): PipelineData = {
    val companyRowDS = sd.getTable(CompanyRowTable)

    val processed = companyRowDS
      .filter(_.employees >= 50)
      .map(CompanyModel.fromRow)

    sd.add(CompanyModelTable, processed)
  }

}

