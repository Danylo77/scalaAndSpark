package com.company

import com.company.config.CompanyConfigLoader
import com.company.pipeline.CompanyPipeline

object CompanyApp {
  def main(args: Array[String]): Unit = {
    val config = CompanyConfigLoader.load()

    val pipeline = new CompanyPipeline(config)
    pipeline.run()
  }
}
