package org.cds.impl.test
import org.cds.impl._
import org.testng.annotations.Test

class MapInitializer {
  @Test
  def testMapFunctionality(): Unit = {
    val map = HashMap[String,String]()
    map.put("something","amazing")
    map.put("something","amazing2")
    map.put("something2","amazing3")
    map.put("something3","amazing4")
    println(map.get("something"))
    println(map.get("something2"))
    println(map.get("something3"))
  }
}

