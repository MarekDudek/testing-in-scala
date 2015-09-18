package testing.fixtures.same

import org.scalatest._
import scala.language.postfixOps

class MixingInBeforeAndAfter extends FlatSpec with BeforeAndAfter {

  val builder = new StringBuilder

  before {
    builder append "one"
  }

  after {
    builder clear
  }

  "This test" should "check builder" in {
    assert(builder.toString === "one")
  }

  it should "check builder again" in {
    assert(builder.toString === "one")
  }
}