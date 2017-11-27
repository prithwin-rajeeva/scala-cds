package org.cds.impl.test
import org.cds.impl.{_}

object MapInitializer {
  def main(args: Array[String]): Unit = {
    val map = HashMap[String,String]()
    map.add("something","amazing")
    map.add("something","amazing2")
    map.add("something2","amazing3")
    print()
  }
}

