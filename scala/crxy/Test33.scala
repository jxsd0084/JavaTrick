package crxy

/**
  * 元组
  */
object Test33 extends App {

  //  元组定义
  //  对偶(使用“()”表示)只是元组最简单的形式  使用（）表示
  var t = (1, 2, 3, 4)

  //  元组不能使用for遍历
  //  for (i <- t) {
  //    println(i)
  //  }

  println(t _3) //  元组的下标从1开始
  println(t _1)

  //  元组的下标从1开始
  //  var (first, second, third, forth) = t
  //  var (first,second,third,_) = t
  //  println(second)

  var s = "Hello World!"
  println(s.partition(_.isUpper))


  //拉链操作
  var arr1 = Array(1, 2, 3, 4, 5, 6)
  var arr2 = Array("a", "b", "c", "d", "e")
  var arr3 = arr1.zip(arr2) //
  for (i <- arr3) {
    println(i)
  }


  println(arr3.mkString(","))
  var map = arr3.toMap // map
  for (i <- map) {
    println(i)
  }

}