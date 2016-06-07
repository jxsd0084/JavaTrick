package crxy

/**
  * 继承--抽象类
  */

abstract class Person {
  //  抽象类不一定有抽象字段或者抽象方法
  //  有抽象字段或者抽象方法的类  一定是抽象类
  var name: String
  val age: Int

  def story: String
}

//方式一
class Student extends Person {
  //  覆盖字段时实质上是覆盖了字段setter、getter方法
  var name: String = "Jeckson"
  //  var定义的字段只能使用var覆盖，并且var覆盖只能是为实现的字段
  val age: Int = 20

  //  使用val定义的字段只能使用val覆盖
  //  def story = "dance"

  def story = "dance" //  使用def定义的抽象方法可以使用def覆盖也可以使用val ，当def为无参时函数可以使用val
}

//方式二
class Student2(var name: String = "Jeckson", val age: Int = 20, val story: String = "dance") extends Person


object Test71 extends App {

    var c = new Student
    println(c.name)
    println(c.age)
    println(c.story)

    var p = new Person {
    //  方式三  匿名子类
    var name: String = "Jeckson"
    //  var定义的字段只能使用var覆盖，并且var覆盖只能是为实现的字段
    val age: Int = 20

    //  使用val定义的字段只能使用val覆盖
    def story = "dance"

  }

}