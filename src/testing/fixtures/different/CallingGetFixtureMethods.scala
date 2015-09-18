package testing.fixtures.different

import org.scalatest.FlatSpec
import collection.mutable.ListBuffer
import scala.language.reflectiveCalls

class CallingGetFixtureMethods extends FlatSpec {

  def fixture = new {
    val builder = new StringBuilder("one")
    val list = ListBuffer(1)
  }

  "This test" should "use fixture" in {
    val f = fixture
    f.builder.append(" two")
    assert(f.builder.toString === "one two")
  }

  "This test" should "have independent fixture" in {
    val f = fixture
    assert(f.builder.toString === "one")
  }

  "This test" should "not use fixture at all" in {
    assert(true)
  }

  "This test" should "uses imported members" in {
    val f = fixture
    import f._
    list += 2
    assert(list === ListBuffer(1, 2))
  }
}