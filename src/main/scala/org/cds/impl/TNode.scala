package org.cds.impl

case class TNode(var data:Int,var  left:TNode ,var right : TNode) {
  def < (other:TNode) :Boolean = {
    if(this.data < other.data) true else false
  }

  def > (other:TNode) :Boolean = {
    if(this.data > other.data) true else false
  }

  override def toString: String = data+""
}

object TNode {
  def apply(data:Int): TNode = new TNode(data, null, null)
}
