package testing.matchers

import org.scalatest._
import Matchers._
import MustMatchers._

import java.io._
import java.util.ArrayList

import language.postfixOps

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

  it should "customize equality to check with tolerance" in {

    import scala.math._

    sqrt(2) must equal(1.41 +- 0.01)
    sqrt(2) must ===(1.41 +- 0.01)
    sqrt(2) mustEqual 1.41 +- 0.01

    // below works contrary to what docs say
    sqrt(2) mustBe 1.41 +- 0.01
    sqrt(2) must be(1.41 +- 0.01)
  }

  it should "use negation" in {

    2 + 2 should not equal (5)
    2 + 2 must not equal (5)

    2 + 2 should !==(6)
    2 + 2 must !==(6)

    2 + 2 should not be (7)
    2 + 2 must not be (7)
  }

  it should "compare arrays" in {

    Array(1, 2) mustEqual Array(1, 2)
    Array(1, 2) mustBe Array(1, 2)

    Array(1, 2) == Array(1, 2) mustEqual false
  }

  it should "compare string after normalization" in {

    import org.scalactic.StringNormalizations._

    "Hi" must equal("hi")(after being lowerCased)
  }

  it should "check size and length" in {

    "string" must have size 6
    "string" must have length 6

    Array(1, 2, 3) must have size 3
    Array(1, 2, 3) must have length 3

    List(1, 2, 3, 4) must have size 4
    List(1, 2, 3, 4) must have length 4

    val list = new ArrayList[Int]
    list add 1; list add 2; list add 3

    list must have size 3
    list must have length 3
  }

  it should "check for emptiness" in {

    List() shouldBe empty

    "" mustBe empty

    Array() mustBe empty

    new ArrayList mustBe empty
  }

  it should "check for belonging" in {

    Array(1, 2, 3) must contain(2)
    "string" must contain('r')
    List("one", "two", "three") must contain("two")
    Map('a' -> 1, 'b' -> 2, 'c' -> 3) must contain('b' -> 2)
    Some(2) must contain(2)

    import org.scalactic.StringNormalizations._

    (List("One", "Two", "Three") must contain("two"))(after being lowerCased)
  }

  it should "check for more complicated cases of belonging" in {

    val list = List(1, 2, 3)

    list must contain oneOf (3, 4)
    list must not contain oneOf(2, 3)

    list must contain atLeastOneOf (2, 3)
    list must contain atMostOneOf (3, 4)

    list must contain noneOf (4, 5)
    list must contain allOf (3, 1, 2)

    list must contain theSameElementsAs List(2, 1, 3)

    List(1, 2, 3, 2, 1) must contain only (1, 2, 3)
  }

  it should "check strings" in {

    "string" must startWith("str")
    "string" must endWith("ing")
    "string" must include("ri")

    "string" must startWith regex "s.r"
    "string" must endWith regex "i?ng"
    "string" must include regex "r*"

    "string" should fullyMatch regex "s.*n."

    "string" must startWith regex ("s(.*)i(.?n)" withGroups ("tr", "n"))
    "string" must endWith regex ("(t.*)i(.*g)" withGroups ("tr", "ng"))
    "string" must include regex ("(t.*)i(.*n)" withGroups ("tr", "n"))

    "string" should fullyMatch regex ("s(t.*)(i.*)g" withGroups ("tr", "in"))
  }

  it should "show greater and less then comparisons" in {

    1 must be > 0
    1 must be < 2
    1 must be >= 1
    1 must be <= 1
  }

  class SomeClass(val good: Boolean)

  it should "check boolean property" in {

    val some = new SomeClass(true)

    assert(some.good === true)
    some mustBe 'good

    val dir = new File("src")

    assert(dir isDirectory)
    dir mustBe 'directory

    val file = new File(".gitignore")

    assert(file isFile)
    file mustBe 'file
  }

  it should "check object's class" in {

    val some = new SomeClass(true)

    some mustBe a[SomeClass]

    val list = new ArrayList[Int]

    list mustBe an[ArrayList[_]]
    list mustBe a[java.util.List[_]]
  }

  it should "check object identity" in {

    val foo = List(1)
    val bar = foo

    bar must be theSameInstanceAs foo
  }
}