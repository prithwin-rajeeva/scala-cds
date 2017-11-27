package org.cds.impl

case class Entry[K, V](key:K, var value:V, var next:Entry[K,V])

object Entry {
  def apply[K,V](key:K,value:V): Entry[K,V] = new Entry[K,V](key,value,null)
}
