package crxy

/**
  * 伴生对象
  */

class TestObject51 {

  private var value = 10

  def display {
    println(TestObject51.value)
  }

  def show(a: TestObject51) {
    //  自定义getter方法
    this.value = TestObject51.value
  }
}

/*伴生对象*/
object TestObject51 {
  //  对象使用object定义
  //  该对象作为同名类的伴生对象
  //  private[this] var value = 10
  private var value = 10

  private def show {
    println("超人")
  }
}

object Test51 extends App {
   println("hello world!");
//  println(TestObject51.value) //  不能访问对象中的私有字段
//  println(TestObject51.show)

}