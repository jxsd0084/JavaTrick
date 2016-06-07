package com.dt.scala.list

/**
 * @author Wang Jialin
 * Date��2015/8/8
 * Contact Information:
 * WeChat:	18610086859
 * QQ:		1740415547
 * Email: 18610086859@126.com
 * Tel:	18610086859
 */

abstract class Big_Data
class Hadoop extends Big_Data
class Spark extends Big_Data

object List_Constructor_Internals {

  def main(args: Array[String]) {
    println("hello world!");
    val hadoop = new Hadoop :: Nil
    println("-> ", hadoop)    //  (-> ,List(com.dt.scala.list.Hadoop@475530b9))

    val big_Data = new Spark :: hadoop
    println("-> ", big_Data)  //  (-> ,List(com.dt.scala.list.Spark@4c70fda8, com.dt.scala.list.Hadoop@475530b9))
    println("hello world!");
  }

}