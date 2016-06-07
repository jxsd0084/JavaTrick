package crxy

/**
  * 类的构造器
  */
/*
class TestClass43(var name: String = "xxx", var age: Int = 0) {
  //主构造器  带参数称为默认值

  var name: String
  //  需要初始化
  var age: Int
  //  public TestClass43 {
  //  } //  java的构造器写法
  println("name=" + name)
  println("age=" + age)

}
*/

class TestClass43 {
  //  辅助构造器
  var name: String = "lisi"
  //  需要初始化
  var age: Int = 0

  // 辅助构造器第一行要调用主构造器
  def this(name: String) {
    this()
    this.name = name
    println("第一个辅助构造器")
  }

  // 还可以调用其他辅助构造器
  def this(name: String, age: Int) {
    this(name)
    this.name = name
    this.age = age
    println("第二个辅助构造器")
  }

  println("name=" + name + " age=" + age)

  def show = {
    "name!=" + name + " age!=" + age
  }
}


object Test43 extends App {
  var c = new TestClass43("wangwu", 90)
  println("name=" + c.name)
  println("age=" + c.age)

  println(c.show)


}