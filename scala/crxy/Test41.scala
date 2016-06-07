package crxy

import scala.beans.BeanProperty

/**
  * 类的基本内容
  */

class TestClass41 {
  //  @BeanProperty var monary = 100
  var monary = 100

  def show {
    println("hello")
  }
}


object Test41 extends App {

  var a = new TestClass41() //  实例化一个类
  a.monary = 200
  println(a.monary)
  println(a.show)

  //  scala使用var定义字段 默认生成对应的setter和getter方法  对应的名称monary_= 和 monary
  //  a setMonary 300
  //  println(a getMonary)

  //  使用val定义字段的时候  scala不在提供setter方法

  //  @BeanProperty和private不能同时共用

}