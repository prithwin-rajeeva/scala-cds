package org.cds.impl

/**
  * Created by prajeeva on 11/19/17.
  */
case class AVLTreeEntry[K,V](key:K,
                           var value:V,
                           var left:AVLTreeEntry[K,V],
                           var right:AVLTreeEntry[K,V],var height:Int) {
  override def toString: String = ""+key
}

object AVLTreeEntry {
  def apply[K,V](k:K,v:V):AVLTreeEntry[K,V] = new AVLTreeEntry[K,V](k,v,null,null,0)
}

