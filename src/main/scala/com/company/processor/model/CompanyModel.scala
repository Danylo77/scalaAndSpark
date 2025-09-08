package com.company.processor.model

case class CompanyModel(
                         companyName: String,
                         revenue: Long,
                         employees: Int,
                         revenuePerEmployee: Double
                       )