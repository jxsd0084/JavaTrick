package crxy

/**
  * 函数
  */
object Test11 extends App {

  /*无返回值的函数*/
  def add(a: Int, b: Int) {
    println(a + b)
  }

  add(1, 2)

  /*有返回值的函数*/
  //  ()作为scala中一个类型-- Unit类型
  //  如果返回值强制指定为Unit  返回就是Unit类型
  def add2(a: Int, b: Int): Int = {
    a + b //  默认返回最后一行的值
  }

  var c = add2(1, 2)
  println(c)

/*
  编译器提示报错
  def add3(a: Int, b: Int): Unit = {
    a + b
  }
*/

  /*小知识点*/
  //  1.可以不写“;” 如果一行上有多条语句的情况下要写
  //	2.scala可以使用带参调用方式
  //  var c = add(b = 1, 3, 1)
  //  println(c)

}