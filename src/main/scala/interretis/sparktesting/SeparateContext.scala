package interretis.sparktesting

import interretis.sparktesting.ContextCreator.context
import org.apache.spark.SparkContext
import org.scalatest.{Outcome, fixture}

import scala.language.postfixOps

trait SeparateContext extends fixture.FlatSpec {

  case class FixtureParam(sc: SparkContext)

  def withFixture(test: OneArgTest): Outcome = {
    val sc = context()
    try
      withFixture(test toNoArgTest FixtureParam(sc))
    finally
      sc stop
  }
}
