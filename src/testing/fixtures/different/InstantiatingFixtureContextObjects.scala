package testing.fixtures.different

import org.scalatest.FlatSpec
import collection.mutable.ListBuffer

class InstantiatingFixtureContextObjects extends FlatSpec {

  trait Builder {
    val builder = new StringBuilder("one")
  }

  trait List {
    val list = ListBuffer(1)
  }

  "This test" should "only require builder" in new Builder {
    assert(builder.toString === "one")
  }

  "This test" should "only require list" in new List {
    assert(list === List(1))
  }

  "This test" should "use both builder and list" in new Builder with List {
    assert(builder.toString === "one")
    assert(list === List(1))
  }
}