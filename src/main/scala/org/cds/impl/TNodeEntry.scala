package org.cds.impl

/**
  * Created by prajeeva on 11/19/17.
  */
case class TNodeEntry[K,V](k:K,
                           var v:V,
                           var left:TNodeEntry[K,V],
                           var right:TNodeEntry[K,V])

object TNodeEntry {
  def apply[K,V](k:K,v:V):TNodeEntry[K,V] = new TNodeEntry[K,V](k,v,null,null)
}

