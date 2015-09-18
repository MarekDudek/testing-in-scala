package testing.fixtures.same

import org.scalatest._
import language.postfixOps
import collection.mutable.ListBuffer

class ComposingFixturesWithBeforeAndAfter extends FlatSpec with Builder2 with Buffer2 {

  "This test" should "have access to builder" in {
    assert(builder.toString === "one")
    assert(buffer === ListBuffer(1))
  }

  "This test" should "also have access to builder" in {
    assert(builder.toString === "one")
    assert(buffer === ListBuffer(1))
  }
}

trait Builder2 extends BeforeAndAfterEach {

  this: Suite =>

  val builder = new StringBuilder

  override def beforeEach {
    builder append "one"
    super.beforeEach
  }

  override def afterEach {
    try
      super.afterEach
    finally
      builder clear
  }
}

trait Buffer2 extends BeforeAndAfterAll {

  this: Suite =>

  val buffer = new ListBuffer[Int]

  override def beforeAll {
    buffer += 1
  }

  override def afterAll {
    buffer clear
  }
}