package testing.fixtures.different

import org.scalatest.FlatSpec
import collection.mutable.ListBuffer

class InstantiatingFixtureContextObjects extends FlatSpec {

  protected trait Builder {
    val builder = new StringBuilder("one")
  }

  trait List {
    val list = ListBuffer(1)
  }

  "This test" should "only require builder" in new Builder {
    builder append " two"
    assert(builder.toString === "one two")
  }

  "This test" should "only require list" in new List {
    list += 2
    assert(list === List(1, 2))
  }

  "This test" should "use both builder and list" in new Builder with List {
    assert(builder.toString === "one")
    assert(list === List(1))
  }
}