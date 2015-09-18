package testing.fixtures.different

import org.scalatest.FlatSpec
import collection.mutable.ListBuffer
import scala.language.reflectiveCalls

class CallingGetFixtureMethods extends FlatSpec {

  def builderFixture = new {
    val builder = new StringBuilder("one")
  }

  def bufferFixture = new {
    val buffer = ListBuffer(1)
  }

  "This test" should "use fixture" in {
    val f = builderFixture

    f.builder.append(" two")
    assert(f.builder.toString === "one two")
  }

  "This test" should "have independent fixture" in {
    val f = builderFixture

    f.builder.append(" two")
    assert(f.builder.toString === "one two")
  }

  "This test" should "not use fixture at all" in {
  }

  "This test" should "uses imported members" in {
    val f = bufferFixture
    import f._

    buffer += 2
    assert(buffer === ListBuffer(1, 2))
  }
}