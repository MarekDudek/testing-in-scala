package testing.fixtures.same

import org.scalatest.fixture.FlatSpec
import org.scalatest.fixture

import scala.language.postfixOps

import java.io._

class OverridingWithFixtureMethodOneArgTest extends fixture.FlatSpec {

  case class FixtureParam(file: File, writer: PrintWriter)

  def withFixture(test: OneArgTest) = {

    val file = new File("trash/withFixture-one-arg-test.txt")
    val writer = new PrintWriter(file)

    val fixture = FixtureParam(file, writer)

    try
      withFixture(test.toNoArgTest(fixture))
    finally
      writer close
  }

  "This test" should " do something with file" in {
    f =>
      assert(2 + 2 === 4)
      f.writer write "from inside of test"
  }

  "This test" should " do something with file again" in {
    f =>
      import f._
      assert(2 + 2 === 4)
      writer write "from inside of test"
  }
}