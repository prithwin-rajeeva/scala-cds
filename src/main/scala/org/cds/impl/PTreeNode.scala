package org.cds.impl

/**
  * Created by prajeeva on 11/19/17.
  */
case class PTreeNode(node:scala.collection.mutable.Map[Char,PTreeNode]
                     ,var count:Int
                     ,var end:Boolean)

object PTreeNode {
  def apply():PTreeNode = new PTreeNode(new scala.collection.mutable.HashMap[Char,PTreeNode](),0,false)
}
