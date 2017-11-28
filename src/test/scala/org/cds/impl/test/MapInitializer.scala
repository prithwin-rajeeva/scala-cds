package org.cds.impl.test
import org.cds.impl._
import org.testng.annotations.Test

class MapInitializer {
  @Test
  def testMapFunctionality(): Unit = {
    val map = HashMap[String,String]()
    map.add("something","amazing")
    map.add("something","amazing2")
    map.add("something2","amazing3")
    map.add("something3","amazing4")
    println(map.get("something"))
    println(map.get("something2"))
    println(map.get("something3"))
  }
}

