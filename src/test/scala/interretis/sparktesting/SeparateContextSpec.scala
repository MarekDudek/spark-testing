package interretis.sparktesting

import org.scalatest.Matchers

class SeparateContextSpec extends SeparateContext with Matchers {

  "processing" should "be performed with Spark context" in { f =>
    val numbers = f.sc parallelize (1 to 10)
    val sum = numbers reduce (_ + _)
    sum shouldBe 55
  }

  "another test" should "not interfere" in { f =>
    val numbers = f.sc parallelize (1 to 5)
    val sum = numbers reduce (_ + _)
    sum shouldBe 15
  }
}
