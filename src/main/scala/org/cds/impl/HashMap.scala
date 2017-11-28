package org.cds.impl

case class HashMap[K,V](private val buckets:Array[Entry[K,V]]) {

  def add(key:K, value:V): Unit = {
    val b = Math.abs(key.hashCode() % buckets.length)
    val entry = Entry(key,value)
    if(buckets(b) == null) {
      buckets(b) = entry
    } else {
      var temp = buckets(b)
      if(temp.key.equals(key)) {
        temp.value = value
        return
      }
      while(temp.next!=null) {
        if(temp.key.equals(key)) {
          temp.value = value
          return
        }
        temp = temp.next
      }
      temp.next = entry
    }
  }

  def get(key:K):V = {
    var temp = buckets(Math.abs(key.hashCode()%buckets.length))
    while(temp!=null) {
      if(temp.key.equals(key)) return temp.value
      temp = temp.next
    }
    temp.value
  }
}

object HashMap {
  def apply[K,V](): HashMap[K,V] =
    new HashMap[K,V](new Array[Entry[K, V]](50))
}