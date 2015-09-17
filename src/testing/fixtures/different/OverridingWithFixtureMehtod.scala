package testing.fixtures.different

import org.scalatest._
import java.io._

import scala.language.postfixOps

class OverridingWithFixtureMehtod extends FlatSpec {

  override def withFixture(test: NoArgTest): Outcome = {

    val file = new File("test.txt")
    val writer = new PrintWriter(file)
    writer write "some content"
    writer close

    val outcome = super.withFixture(test)

    file.delete

    outcome
  }

  "This test" should "do something but not necessarily" in {
    assert(2 + 2 === 4)
  }
}