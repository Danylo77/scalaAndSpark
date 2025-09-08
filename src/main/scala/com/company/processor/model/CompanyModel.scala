package com.company.processor.model

import com.company.reader.CompanyRow

case class CompanyModel(
                         companyName: String,
                         revenue: Long,
                         employees: Int,
                         revenuePerEmployee: Double
                       )

object CompanyModel {
  def fromRow(row: CompanyRow): CompanyModel =
    CompanyModel(
      companyName = row.companyName,
      revenue = row.revenue,
      employees = row.employees,
      revenuePerEmployee = row.revenue.toDouble / row.employees
    )
}
