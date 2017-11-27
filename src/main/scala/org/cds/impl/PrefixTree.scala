package org.cds.impl

/**
  * A scala based Prefix tree implementation. just as a scala coding exercise.
  */
case class PrefixTree(root:PTreeNode) {

  /**
    * Adds a string to this prefix tree
    * @param word the word to be added to this tree
    * @return this is a counting insert that means that you get the nuber of times this is presesnt in ths trie
    *         Immediately.
    */
  def put(word:String):Int = {
    var temp = root
    word.toCharArray foreach (c => {
      if (!temp.node.contains(c)) {
        temp.node.put(c, PTreeNode())
      }
      temp = temp.node(c)
    })
    temp.count+=1
    temp.end = true
    temp.count
  }

  /**
    * this method returns 0 or the number of times a certain number appears in a String.
    * @param word the word to look for
    * @return 0 or the number of times the string appears in this tree
    */
  def get(word:String):Int = {
    var temp = root
    word.toCharArray.foreach(c => {
      if(temp.node.get(c).isEmpty) {return 0}
      temp = temp.node(c)
    })
    temp.count
  }
}

object PrefixTree {
  def apply():PrefixTree = {
    new PrefixTree(PTreeNode())
  }
}