package com.company.common

case class PipelineData(tables: Map[TableId[_], Seq[_]] = Map.empty) {
  def add[T](id: TableId[T], data: Seq[T]): PipelineData = copy(tables + (id -> data))

  def getTable[T](id: TableId[T]): Seq[T] = tables(id).asInstanceOf[Seq[T]]
}

trait TableId[T]