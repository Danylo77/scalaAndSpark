package com.company.config

object CompanyConfigLoader {

  import com.typesafe.config.ConfigFactory

  def load(): CompanyConfig = {
    val config = ConfigFactory.load()
    val path = config.getString("company.filepath")
    CompanyConfig(path)
  }
}