package org.cds.impl

/**
  * An avl tree backed implementation of a tree map
  */
case class AVLTreeMap[K <: Comparable[K],V >: Null](var root:AVLTreeEntry[K,V]) extends Map[K,V]{

  override def put(key: K, value: V): Unit = {
    val data = AVLTreeEntry(key,value)
    root = add(root,data)
  }

  def simplify(num: Int):Int = {
    if(num == 0) num
    else if(num < 0) -1
    else 1
  }

  private def add(node:AVLTreeEntry[K,V], data:AVLTreeEntry[K,V]):
                          AVLTreeEntry[K,V] = node match {
    case null => data
    case _ =>
      simplify(data.key.compareTo(node.key)) match {
        case 0 => node.value = data.value
        case -1 => node.left = add(node.left,data)
        case 1 => node.right = add(node.right,data)
      }
      compute(node)
      balance(node)
  }

  private def balance(node: AVLTreeEntry[K, V]):AVLTreeEntry[K,V] = {
    var response = node
    if(getBalanceFactor(node) > 1) {
       if(getBalanceFactor(node.right) < 1) {
         node.right = rotateRight(node.right)
       }
       response = rotateLeft(node)
    }
    else if(getBalanceFactor(node) < 1) {
      if(getBalanceFactor(node.left) > 1) {
        node.left = rotateLeft(node.left)
      }
      response = rotateRight(node)
    }
    response
  }

  private def rotateLeft(root: AVLTreeEntry[K, V]):AVLTreeEntry[K,V] = {
    val pivot = root.right
    val alpha = root.left
    val beta = pivot.left
    val gamma = pivot.right
    root.left = alpha
    root.right = beta
    pivot.left = root
    pivot.right = gamma
    compute(root)
    compute(pivot)
    pivot
  }

  private def rotateRight(root: AVLTreeEntry[K, V]):AVLTreeEntry[K,V] = {
    val pivot = root.left
    val alpha = pivot.left
    val beta = pivot.right
    val gamma = root.right
    root.right = gamma
    root.left = beta
    pivot.right = root
    pivot.left = alpha
    compute(root)
    compute(pivot)
    pivot
  }



  private def getBalanceFactor(node:AVLTreeEntry[K,V]):Int = {
    getNodeHeight(node.right) - getNodeHeight(node.left)
  }

  private def compute(node:AVLTreeEntry[K,V]):Unit = {
    node.height = 1 + math.max(getNodeHeight(node.left),
    getNodeHeight(node.right))
  }

  private def getNodeHeight(node: AVLTreeEntry[K,V]):Int = node match {
    case null => -1
    case _ =>  node.height
  }

  def get(k:K):V = get(root,k)

  private def get(node:AVLTreeEntry[K,V],key:K):V = {
    if(node == null) return null
    if(simplify(key.compareTo(node.key)) == -1) get(node.left,key)
    else if(simplify(key.compareTo(node.key)) == 1) get(node.right,key)
    else node.value
  }

  override def remove(key: K): Unit = ???

}

object AVLTreeMap {
  def apply[K <: Comparable[K],V >: Null]() = new AVLTreeMap[K,V](null)
}


