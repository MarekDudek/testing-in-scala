package testing.fixtures.same

import org.scalatest._
import scala.collection.mutable.ListBuffer
import scala.language.postfixOps

class ComposingFixturesByStackingTraits extends FlatSpec with Builder with Buffer {

  "This test" should "have access to builder" in {
    assert(builder.toString === "one")
    assert(buffer === ListBuffer(1))
  }

  "This test" should "also have access to builder" in {
    assert(builder.toString === "one")
  }
}

trait Builder extends SuiteMixin { this: Suite =>

  val builder = new StringBuilder

  abstract override def withFixture(test: NoArgTest) = {
    builder append "one"
    try
      super.withFixture(test)
    finally
      builder clear
  }
}

trait Buffer extends SuiteMixin { this: Suite =>

  val buffer = new ListBuffer[Int]

  abstract override def withFixture(test: NoArgTest) = {
    buffer += 1
    try
      super.withFixture(test)
    finally
      buffer clear
  }
}