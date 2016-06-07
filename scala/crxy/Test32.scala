package crxy

import scala.collection.mutable.ArrayBuffer
import java.util.ArrayList

/**
  * 映射
  */
object Test32 extends App {

  /*不可变的映射*/
  //	(zhangsan,18)键值对称作 "对偶", 用()表示
  var map1 = Map[String, Int](("zhangsan", 18), ("lisi", 19))
  map1 += ("wangwu" -> 80)

  //  map1("zhangsan") = 12

  map1 += ("zhangsan" -> 20)
  println(map1("zhangsan"))

  for (i <- map1) {
    println(i)
  }

  if (map1.contains("zhaoliu"))
    println(map1("zhaoliu"))


  /*可变的映射*/
  var mapB = scala.collection.mutable.Map[String, Int]("zhangsan" -> 20, "lisi" -> 12)
  mapB("zhangsan") = 30
  for (i <- mapB) {
    println(i)
  }


  /*与java的互操作*/
  var list = new ArrayList[Int]
  list.add(1)
  list.add(2)

  for (i <- 0 to list.size() - 1) {
    println(list.get(i))
  }

  /*map其他遍历方式*/
  for ((k, v) <- map1) {
    //方式一
    println(k + "->" + v)
  }

  //方式二
  var set1 = map1.keys
  var set2 = map1.keySet
  for (i <- set1) {
    println(map1(i))
  }
  println(set2)

}