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

  it should "show how to compare arrays" in {

    Array(1, 2) mustEqual Array(1, 2)
    Array(1, 2) mustBe Array(1, 2)

    Array(1, 2) == Array(1, 2) mustEqual false
  }

  it should "show supplying implicit parameters explicitly" in {

    import org.scalactic.StringNormalizations._

    "Hi" must equal("hi")(after being lowerCased)
  }

  it should "show checking size and length" in {

    "string" must have size 6
    "string" must have length 6

    Array(1, 2, 3) must have size 3
    Array(1, 2, 3) must have length 3

    List(1, 2, 3, 4) must have size 4
    List(1, 2, 3, 4) must have length 4

    val list = new java.util.ArrayList[Int]()
    list add 1; list add 2; list add 3

    list must have size 3
    list must have length 3
  }
}