package testing.matchers

import org.scalatest._
import Matchers._
import MustMatchers._

class MatchersSpec extends FlatSpec with Matchers {

  "This test" should "shows all options" in {

    2 + 2 should equal(4)
    2 + 2 should ===(4)
    2 + 2 should be(4)
    2 + 2 shouldEqual 4
    2 + 2 shouldBe 4

    2 + 2 must equal(4)
    2 + 2 must ===(4)
    2 + 2 must be(4)
    2 + 2 mustEqual 4
    2 + 2 mustBe 4
  }

  it should "show how you can customize equality" in {

    import scala.math._

    sqrt(2) must equal(1.41 +- 0.01)
    sqrt(2) must ===(1.41 +- 0.01)
    sqrt(2) mustEqual 1.41 +- 0.01

    // below works contrary to what docs say
    sqrt(2) mustBe 1.41 +- 0.01
    sqrt(2) must be(1.41 +- 0.01)
  }
}