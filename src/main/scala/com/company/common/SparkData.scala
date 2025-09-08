package com.company.common

import org.apache.spark.sql.Dataset

case class SparkData(tables: Map[TableId[_], Dataset[_]] = Map.empty) {

  def add[T](id: TableId[T], ds: Dataset[T]): SparkData =
    copy(tables = tables + (id -> ds))

  def getTable[T](id: TableId[T]): Dataset[T] =
    tables(id).asInstanceOf[Dataset[T]]
}

trait TableId[T] extends Serializable