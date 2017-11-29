package org.cds.impl

case class HashMap[K <: Comparable[K],V](private val buckets:Array[Entry[K,V]]) extends Map[K,V]{

  def put(key:K, value:V): Unit = {
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

  /*
    remember when i first Added this item, this used to have three question marks next to it.
    this is a feature of scala to aid the compiler in letting a method compile witout a defination
    this is useful for very obvious reasons
    */
  override def remove(key: K): Unit = {
    val bucket = Math.abs(key.hashCode()%buckets.length)
    buckets(bucket) match {
      case null =>
      case _ =>
        var temp = buckets(bucket)
        temp.next match {
          case null => buckets(bucket) = null
          case _ =>
            var prev = temp
            temp = temp.next
            while(temp.next != null) {
              temp.key match {
                case `key` => prev.next = temp.next
              }
              prev = prev.next
              temp = temp.next}
        }
    }
  }
}

object HashMap {
  def apply[K <: Comparable[K],V](): HashMap[K,V] =
    new HashMap[K,V](new Array[Entry[K, V]](50))
}