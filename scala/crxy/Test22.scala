package crxy

/**
  * while 和 for循环
  */
object Test22 extends App {

  /*while循环*/
  while (true) {
    println("hello")
  }

  /*for循环  scala中的for基本形态*/

  //    for(int i = 0 ; i < 5 ; i++)  //  java的for循环
  //    for( i : List)    			      //  增强for


  println(1 to 10)                    // Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)


  for (i <- 1 to 10) {
    //  闭区间
    println(i)
  }

  for (i <- 1 until 10) {
    //  开区间
    println(i)
  }

  for (i <- 1 until 10 reverse) {
    //  倒序  不能使用 10 to 1
    println(i)
  }

  /*高级for循环*/
  //  守卫
  for (i <- 1 to 10 reverse; if i % 3 == 0) {
    println(i)
  }

  //  改变步长
  for (i <- 1 to (10, 3)) {
    println(i)
  }

  //  双重for循环
  for (i <- 1 to 10; j <- 1 to 5) {
    println(i + " - " + j)
  }

  //  for的推导式
  var c = for (i <- 1 to 10) yield (i * 2)
  println(c)

}