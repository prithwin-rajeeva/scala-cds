package org.cds.impl.test

import org.cds.impl._
import org.testng.annotations.Test

class TrieInitializer {

  @Test def testFunctionality(): Unit = {
    val trie = PrefixTree()
    trie.put("absent")
    trie.put("absent")
    trie.put("absent")
    trie.put("absentee")
    println(trie.get("absent"))
    println(trie.get("absentee"))
  }
}