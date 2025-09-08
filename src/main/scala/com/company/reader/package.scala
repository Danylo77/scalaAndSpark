package com.company

import com.company.common.TableId

package object reader {

  case object CompanyRowTable extends TableId[CompanyRow]

  case class CompanyRow(
                         companyName: String,
                         revenue: Long,
                         employees: Int
                       )
}
