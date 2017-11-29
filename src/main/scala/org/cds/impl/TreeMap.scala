package org.cds.impl

case class TreeMap[K <: Comparable[K],V >: Null](var root:TNodeEntry[K,V]) extends Map[K,V]{
  def put(k:K,v:V):Unit = {
    root = put(root,k,v)
  }

  def remove(k:K):Unit = {
    root = remove(root,k)
  }

  def findMin(node: TNodeEntry[K, V]):TNodeEntry[K,V] = {
    if(node.left == null) return node
    findMin(node.left)
  }

  private def remove(node:TNodeEntry[K,V], k:K):TNodeEntry[K,V] = {
    if(node == null) return null
    if(k.compareTo(node.k) == -1) {
      node.left = remove(node.left,k)
    } else if(k.compareTo(node.k) == 1) {
      node.right = remove(node.right,k)
    } else {
      if(node.left == null) return node.right
      if(node.right == null) return node.left
      var temp = node
      val min = findMin(temp)
      temp.v = min.v
      temp = deleteMin(temp.right)
    }
    node
  }

  private def deleteMin(node:TNodeEntry[K,V]):TNodeEntry[K,V] = {
    if(node.left == null) return node.right
    node.left = deleteMin(node.left)
    node
  }

  def get(k:K):V = get(root,k)

  private def get(node:TNodeEntry[K,V],k:K):V = {
    if(node == null) return null
    if(k.compareTo(node.k) == -1) get(node.left,k)
    else if(k.compareTo(node.k) == 1) get(node.right,k)
    else node.v
  }

  private def put(node:TNodeEntry[K,V],k:K,v:V): TNodeEntry[K,V] = if(node == null) TNodeEntry(k,v)
  else {
    if(k.compareTo(root.k) == -1) node.left = put(node.left,k,v) else if(k.compareTo(root.k) == 1)
      node.right = put(node.right,k,v) else node.v = v
    node
  }
}

object TreeMap {
  def apply[K <: Comparable[K],V >: Null]():TreeMap[K,V] = new TreeMap[K,V](null)
}
