package com.company.common

trait PipelineStep {
  def process(sd: PipelineData): PipelineData
}