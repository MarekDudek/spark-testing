package interretis.sparktesting

import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.scalatest.{Outcome, fixture}

import scala.language.postfixOps

trait SeparateSqlContext extends fixture.FlatSpec {

  case class FixtureParam(sc: SparkContext, sqlCtx: SQLContext)

  def withFixture(test: OneArgTest): Outcome = {
    val sc = ContextCreator.context()
    val sql = ContextCreator.sqlContext(sc)
    try
      withFixture(test toNoArgTest FixtureParam(sc, sql))
    finally
      sc stop
  }
}
