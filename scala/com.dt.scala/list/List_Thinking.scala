package com.dt.scala.list

/**
  * @author Wang Jialin
  *         Date��2015/8/7
  *         Contact Information:
  *         WeChat:	18610086859
  *         QQ:		1740415547
  *         Email: 18610086859@126.com
  *         Tel:	18610086859
  */
object List_Thinking {

  def main(args: Array[String]) {
    val list: List[Int] = List(1, 2, 3, 4, 5)
    val listAny: List[Any] = list
    println("list.isEmpty ", list.isEmpty)  //  false
    println("list.head ", list.head)        //  1
    println("list.tail ", list.tail)        //  List(2, 3, 4, 5)
    println("list.length ", list.length)    //  5
    println("list.drop ", list.drop(2))     //  List(3, 4, 5)

    println(list.isEmpty)                   //  false
    println(list.head)                      //  1
    println(list.tail)                      //  List(2, 3, 4, 5)
    println(list.length)                    //  5
    println(list.drop(2))                   //  List(3, 4, 5)

    println(list.map(_ * 2))                //  List(2, 4, 6, 8, 10)
  }

}