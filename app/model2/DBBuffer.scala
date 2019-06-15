package model2


import scala.reflect.ClassTag

//case class WithID(id:Int)

class DBBuffer[T <: WithID:ClassTag] {

  private val buff = collection.mutable.ArrayBuffer[T]()

  def updateBuffer(items:Array[T]):Unit = {
    buff ++= items
  }

  def items:Array[T] = {
    buff.toArray
  }

  def getEvent(id:Int):T = {
    items.filter(_.id == id).head
  }

}

//class DBBuffer[E <: AbstractTable[_]](tq:TableQuery[E]) {
//
//  type Row = tq.baseTableRow.TableElementType
//
//  private val buff = collection.mutable.ArrayBuffer[Row]()
//
//  def updateBuffer(items:Array[Row]) = {
//    buff ++= items
//  }
//
//  def items:Array[Row] = {
//    buff.toArray
//  }
//
//  def getEvent(id:Int):Row = {
//    items.filter(_.id == id).head
//  }
//}