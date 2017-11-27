package org.cds.impl

import scala.collection.mutable

case class RandomLinkedList(var head:RandomListNode) {
  override def toString: String = {
    var rep = "RandomLinkedList("
    var temp = head
    while(temp!=null) {
      rep += temp
      if(temp.next!=null)
        rep += ","
      temp = temp.next
    }
    rep += ")"
    rep
  }

  override def clone(): RandomLinkedList = {
    var temp = head
    val reg = mutable.TreeMap[RandomListNode , RandomListNode]()
    while (temp != null) {
      reg.put(temp, RandomListNode(temp.label))
      temp = temp.next
    }
    temp = head
    while(temp!=null) {
      reg(temp).next = reg(temp.next)
      reg(temp).random = reg(temp.random)
      temp = temp.next
    }
    RandomLinkedList(reg(head))
  }

}

object RandomLinkedList {
  def apply(): RandomLinkedList = new RandomLinkedList(null)
}
