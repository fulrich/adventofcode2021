import org.scalatest._
import matchers.should.Matchers._
import org.scalatest.funsuite.AnyFunSuite

class Test1 extends AnyFunSuite:
  test("Simple test") {
    msg shouldBe "I was compiled by Scala 3. :)"
  }
