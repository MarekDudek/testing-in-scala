package testing.fixtures.same

import org.scalatest._
import collection.mutable.ListBuffer
import scala.language.postfixOps

class MixingInBeforeAndAfterEachAndAll extends FlatSpec with BeforeAndAfterAll with BeforeAndAfterEach {

  val builder = new StringBuilder

  override def beforeEach {
    builder append "one"
  }

  override def afterEach {
    builder clear
  }

  val buffer = new ListBuffer[Int]

  override def beforeAll {
    buffer += 1
  }

  override def afterAll {
    buffer clear
  }

  "This test" should "check builder and buffer" in {
    assert(builder.toString === "one")
    assert(buffer === ListBuffer(1))
  }

  it should "check builder and buffer again" in {
    assert(builder.toString === "one")
    assert(buffer === ListBuffer(1))
  }
}