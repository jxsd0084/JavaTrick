package crxy

/**
  * apply方法
  */
object Test52 extends App {

  var arr = new Array[Int](5)
  var arr2 = Array.apply(1, 2, 3, 4) //  构造数组使用的是apply方法

  var map = Map.apply[String, Int]("zhangsan" -> 12)

}