package crxy

import scala.collection.mutable.ArrayBuffer

/**
  * 数组
  */
object Test31 extends App {
  /*定长数组*/
  //  使用new定义数组
  var arr1 = new Array[Int](5)
  arr1(1) = 2
  println(arr1)
  for (i <- arr1) {
    println(i)
  }

  //  使用Array类进行定义
  var arr2 = Array(1, 2, 3, 4, "hehe")
  for (i <- arr2) {
    println(i)
  }

//  编译错误
//  println(arr2.min)
//  println(arr2.max)
//  println(arr2.sum)

  println(arr2.mkString("[", ",", "]"))

//  Arrays.toString(arr)  [1,2,3]

  /*变长数组*/
  var arrbuf1 = ArrayBuffer(1, 2, 3, 4)
  arrbuf1 += 5
  arrbuf1 -= 3
  arrbuf1 ++= Array(3, 4, 5)
  arrbuf1 --= Array(3, 4, 5)
  arrbuf1.toArray
  println(arrbuf1.mkString(","))

  var arrB = arr2.toBuffer
  arrB += 9
  println(arrB.mkString(","))


  // filter 和 map用法
  var arr4 = Array(1, 2, 3, 4, 5)
  var arr5 = arr4.filter(_ % 2 == 0).map(_ * 2)
  println(arr5.mkString(","))
}