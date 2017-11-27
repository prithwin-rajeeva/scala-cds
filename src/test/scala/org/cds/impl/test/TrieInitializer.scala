package org.cds.impl.test

import org.cds.impl.{_}

object TrieInitializer {
  def main(args: Array[String]): Unit = {
    val trie = PrefixTree()
    trie.put("absent")
    trie.put("absent")
    trie.put("absent")
    trie.put("absentee")
    println(trie.get("absent"))
    println(trie.get("absentee"))
  }
}