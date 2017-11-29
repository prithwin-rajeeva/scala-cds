package org.cds.impl

/**
  * defines the traits of the map classes
  * maps allow you to get and put a value associated with a key
  */
trait Map[K <: Comparable[K],V] {
  def put(key:K,value:V)
  def get(key:K):V
  def remove(key:K)
}
