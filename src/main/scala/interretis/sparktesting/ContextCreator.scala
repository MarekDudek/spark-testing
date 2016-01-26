package interretis.sparktesting

import org.apache.spark.{SparkConf, SparkContext}

object ContextCreator {

  def createContext(appName: String = "Test application", master: String = "local[*]"): SparkContext = {

    val config = new SparkConf

    config setAppName appName
    config setMaster master

    new SparkContext(config)
  }
}
