package crxy

/**
  * Created by Administrator on 2016/5/8.
  */
object Test62 extends App {

  //  思考题
  def func7(x: Int, y: Int) = {

    (y: Int) => {
      println(x, y)
      x + y            // ( 3 + 2)  + 2
    } + 2

  }

  println( func7(3, 0) (1) )  //  6
  println( func7(3, 1) (1) )  //  6
  println( func7(3, 2) (1) )  //  6
  println( func7(3, 3) (1) )  //  6


  println( func7(3, 0) (2) )  //  7
  println( func7(3, 1) (2) )  //  7
  println( func7(3, 2) (2) )  //  7
  println( func7(3, 3) (2) )  //  7


  println( func7(3, 0) (3) )  //  8
  println( func7(3, 1) (3) )  //  8
  println( func7(3, 2) (3) )  //  8
  println( func7(3, 3) (3) )  //  8

}
