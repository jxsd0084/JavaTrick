package crxy

/**
  * 类的基本内容2
  */
class TestClass42 {

  private var monary = 0

  //  自定义setter方法
  def setMonary(a: Int) {
    if (a > 0)
      this.monary = a
  }

  //  自定义getter方法
  def getMonary = {
    this.monary
  }

}

object Test42 extends App {
  var c = new TestClass42
//  c setMonary -1000
  c setMonary 1000
  println(c getMonary)

}