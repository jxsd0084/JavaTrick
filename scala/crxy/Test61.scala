package crxy

/**
  * 高阶函数
  */

object Test61 extends App {
  //  函数定义
  def add(a: Int, b: Int) = {
    a + b
  }

  var c = add(1, 2)
  println(c)

  //  把一个函数的实现传递给另外一个函数
  var func1 = add _
  println(func1(1, 2))

  var func2 = (x: Int) => x + 3
  //  传递一个匿名函数给给一个变量
  var func3 = (x: Int) => {
    x + 3
  }
  //  传递一个匿名函数给给一个变量
  var func4 = (x: Int) => (x + 3)


  //  编译错误, 变量arr还没有呢
  /*  for (i <- arr)
      Map[String, Int]("zhangsan" -> 12)
    println(func2(3))*/

  def func5(a: Int, f: (Int) => (Int)) = {
    f(a) + 1
  }

  println(func5(4, (x: Int) => {
    x + 2
  }))

  //  传递一个匿名函数给该函数

  //  调用函数封装举例
  def CPU(a: Int) = {
    a * 8
  }

  def GPU(a: Int) = {
    a + 9
  }

  def compute(men: Int, CPU: (Int) => (Int), GPU: (Int) => (Int)) = {
    men + CPU(2) + GPU(2)
  }

  println(compute(4, CPU, GPU))

  def func6(f: (Int) => (Int)) = {
    f(1)
  }

  println(func6(_ + 2))

  // 简写条件：1.只有一行代码   2.只有一个形参  3.把匿名函数作为形参
  //  println(func6(_ + _))

  //  总结“_”  :
  //	1.代表数组每一个元素
  //	2.指的是传递是确切的一个函数 而不是忘记给该函数传递参数
  //	3.元组的元素取值

  //  思考题
  def func7(x: Int, y: Int) = {
    (y: Int) => {
      x + y
    } + 2
  }

  println(func7(3, 4)(2))

  //  一些有用的函数 map foreach reduceLeft
  (1 to 9).map("*" * _).foreach(println _)

  var d = (1 to 3).reduceLeft(_ * _) // 1 + 2 + 3
  println(d)

}