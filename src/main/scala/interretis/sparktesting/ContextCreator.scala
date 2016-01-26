package interretis.sparktesting

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object ContextCreator {

  def context(appName: String = "Test application", master: String = "local[*]"): SparkContext = {

    val config = new SparkConf

    config setAppName appName
    config setMaster master

    new SparkContext(config)
  }

  def sqlContext(sc: SparkContext): SQLContext = new SQLContext(sc)
}
