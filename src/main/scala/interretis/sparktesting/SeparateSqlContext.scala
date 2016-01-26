package interretis.sparktesting

import interretis.sparktesting.ContextCreator.{context, sqlContext}
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.scalatest.{Outcome, fixture}

import scala.language.postfixOps

trait SeparateSqlContext extends fixture.FlatSpec {

  case class FixtureParam(sc: SparkContext, sql: SQLContext)

  def withFixture(test: OneArgTest): Outcome = {
    val sc = context()
    val sql = sqlContext(sc)
    try
      withFixture(test toNoArgTest FixtureParam(sc, sql))
    finally
      sc stop
  }
}
