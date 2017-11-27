import com.functional.util.PrefixTree

/**
  * Created by prajeeva on 11/19/17.
  */

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