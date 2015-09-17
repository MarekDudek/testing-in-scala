package testing.fixtures.different

import org.scalatest._
import java.io._

import scala.language.postfixOps

class OverridingWithFixtureMehtod extends FlatSpec {

  override def withFixture(test: NoArgTest): Outcome = {

    val file = new File("trash/test.txt")
    val writer = new PrintWriter(file)

    val outcome = super.withFixture(test) match {
      case failed: Failed =>
        failed
      case other =>
        val name = test.name
        writer write s"Test '$name' didn't fail.\n"

        other
    }

    writer close

    outcome
  }

  "This test" should "do something but not necessarily" in {
    assert(2 + 2 === 4)
  }
}