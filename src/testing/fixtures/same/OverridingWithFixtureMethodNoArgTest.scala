package testing.fixtures.same

import org.scalatest._
import java.io._

import scala.language.postfixOps

class OverridingWithFixtureMethodNoArgTest extends FlatSpec {

  override def withFixture(test: NoArgTest): Outcome = {

    val name = test.name

    val file = new File("trash/test.txt")
    val writer = new PrintWriter(file)

    try
      super.withFixture(test) match {
        case failed: Failed =>
          writer write s"Test '$name' failed.\n"
          failed
        case other =>
          writer write s"Test '$name' didn't fail.\n"
          other
      }
    finally
      writer close
  }

  "This test" should "do something but not necessarily" in {
    assert(2 + 2 === 4)
  }
}