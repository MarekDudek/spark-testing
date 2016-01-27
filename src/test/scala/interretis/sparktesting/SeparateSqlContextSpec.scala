package interretis.sparktesting

import org.scalatest.Matchers

class SeparateSqlContextSpec extends SeparateSqlContext with Matchers {

  "sql context" should "allow accessing file" in { f =>
    val people = f.sql.read.json("src/test/resources/people.json")
    people.count() shouldBe 3
  }
}
