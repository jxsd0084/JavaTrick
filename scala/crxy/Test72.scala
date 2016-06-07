package crxy

/**
  * 构造顺序
  */
class Person1 {
  val age: Int = 10
  var arr: Array[Int] = new Array[Int](age) //  调age字段的getter方法
}

/*class student1 extends Person1 {
  override lazy val age: Int = 18           //  如果覆盖的父类不是抽象类  必须要写override
}*/

class student1 extends {
  // 解决办法③
  override val age: Int = 18 //  如果覆盖的父类不是抽象类  必须要写override
} with Person1

//  特质
trait student2 {
  var a: Int = 10
  var b: Int
}

trait student3 {
  def show = "123"
}

class student4 extends student2 with student3 {
  var b: Int = 1
}

object Test72 extends App {
  var c = new student1
  println(c.age)
  println(c.arr.length)
  //  输出18 0
  //      解决办法：1.字段前面添加final  2.字段前面添加lazy  3.解决办法③
  //  原因:
  //      a.主构造器和class类交织在一起
  //      b.子类中使用了override覆盖超类中的字段，构造子类时超类的字段值会被覆盖
  //      c.student1类作为student1的主构造器，调用了超类的Person1的主构造器
  //      d.首先，构造器将age值设置为10
  //      e.接着代码往下走，为了初始化arr数组，调用了age的getter方法
  //      f.而age字段被重写了，也就是说getter方法被重写了
  //      g.被重写的getter方法还没有被初始化，确切说就是字段age还是对象在被分配空间时所有整型字段的初始值
  //      h.arr数组长度被设置为0
  //      i.子类Student1类构造器执行，age被赋值为18
}