package testing.assertions

import org.scalatest.FreeSpec

class AssertionsTest extends FreeSpec {

  "Assertions available in any style trait" - {

    "for general assertions" in {
      assert(2 + 2 == 4)
      assert(2 + 2 == 4, "two and two is four")
    }

    "triple equals gives rich error message" in {
      assert(2 + 2 === 4)
      assert(2 + 2 === 4, "and it should")
    }

    "to differentiate expected from actual values" in {
      assertResult(4) {
        2 + 2
      }
      assertResult(4, "math should work") {
        2 + 2
      }
    }

    "to ensure a bit of code throws an expected exception" in {
      val string = "twenty three"
      intercept[NumberFormatException] {
        string.toInt
      }
      withClue("number expressed with words cannot be parsed") {
        intercept[NumberFormatException] {
          string.toInt
        }
      }
    }
  }

  "Also in Assertions trait" - {

    "assume" - {

      val string = "abc"

      "to cancel a test when assumption not met" in {
        assume(string.length() > 4)
        assert(string.charAt(4) == 'e')
      }
    }

    "fail" - {

      val reallyFail = false

      "to fail a test unconditionally" in {
        assume(reallyFail)
        fail()
      }

      "to fail a test unconditionally with a message" in {
        assume(reallyFail)
        fail("with a message")
      }
    }

  }
}