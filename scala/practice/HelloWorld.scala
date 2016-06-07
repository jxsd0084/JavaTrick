package practice

import scala.collection.mutable.{HashMap, HashSet}

object HelloWorld {

  def function1(n: Int): Int = {
    var multi = (i: Int, m: Int) => i * m
    multi.apply(n, 2)
  }

  def main(args: Array[String]): Unit = {
    // 00
    println("00")
    println("Hello World!")
    println()

    // 01
    println("01")
    var i = 0
    while (i < 10) {
      println("Hello World " + i)
      i += 1
    }
    println()

    // 02
    println("02")
    var strArr = new Array[String](3)
    strArr(0) = "h01"
    strArr(1) = "h02"
    strArr(2) = "h03"
    for (i <- 0 to 2) {
      println(strArr(i))
    }
    println()

    // 03
    println("03")
    var list1 = List("aaa", "bbb", "ccc")
    var list2 = List("ddd")
    var list3 = list1 ::: list2
    list3.foreach { list => print(list + " ") }
    println()
    println()

    // 04
    println("04")
    var set = HashSet("b", 3, "c")
    set += "very"
    set.foreach { value => print(value + " ") }
    println()
    println()

    // 05
    println("05")
    var map = HashMap(1 -> "a", 2 -> "b", 3 -> "c")
    map += (4 -> "d")
    map.foreach(value => print(value + " "))
    println()
    println()

    // 06
    println("06")
    println(function1(2))
    println()
    println()

  }

}
