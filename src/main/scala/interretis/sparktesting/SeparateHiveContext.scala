package interretis.sparktesting

import org.apache.spark.SparkContext
import org.apache.spark.sql.hive.HiveContext
import org.scalatest.{Outcome, fixture}

import scala.language.postfixOps

trait SeparateHiveContext extends fixture.FlatSpec {

  case class FixtureParam(sc: SparkContext, hiveCtx: HiveContext)

  def withFixture(test: OneArgTest): Outcome = {
    val sc = ContextCreator.context()
    val hive = ContextCreator.hiveContext(sc)
    try
      withFixture(test toNoArgTest FixtureParam(sc, hive))
    finally
      sc stop
  }
}
