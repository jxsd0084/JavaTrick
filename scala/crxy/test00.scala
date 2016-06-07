package cn.crxy

trait Person0 {
  var a: Int
  var b: String
}

trait Person1 {
  var c: Int = 2

  def show() {
    println(c)
  }
}

class student0 extends Person0 with Person1 {
  var a = 12
  var b = "* *"

  def show2(): Unit ={
    println(a, b)
  }

  def show3(){
    println(a, b)
  }

}

object test00 extends App {
  var stu = new student0
  stu.show()
  stu.show2()
  stu.show3()

}