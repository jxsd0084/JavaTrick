//package cn.crxy
//
//import org.apache.spark.SparkConf
//import org.apache.spark.SparkContext
//import org.apache.spark.SparkContext._
//
///**
// * @author Administrator
// */
//object wordCount{
//  
//  def main(args: Array[String]) {
//    
//    val conf = new SparkConf()
//    val sc = new SparkContext(conf)
//    val line = sc.textFile("d:\\spark.txt")
//    
//    line.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_+_).collect().foreach(println)
//    
//    sc.stop()    
//    
//  }
//
//}