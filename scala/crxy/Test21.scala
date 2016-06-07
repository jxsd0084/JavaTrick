package crxy

/**
  * 判断if
  */
object Test21 extends App {

  def judge(a: Int): Int = {
    if (a > 0) {
      1                   //  return相当于函数版的break语句
    } else if (a < 0) {
      -1
    } else {
      0
    }
  }

  var c = judge(-3)
  println(c)

}