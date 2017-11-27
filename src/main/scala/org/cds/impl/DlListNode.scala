package org.cds.impl

class DlListNode(var key:Int , var value:Int ,var  prev:DlListNode , var next:DlListNode) {

}

object DlListNode {
  def apply(key: Int, value: Int): DlListNode = new DlListNode(key, value,null , null)
}