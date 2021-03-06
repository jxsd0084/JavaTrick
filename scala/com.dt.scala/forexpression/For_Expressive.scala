package com.dt.scala.forexpression

/**
  * @author Wang Jialin
  *         Date��2015/8/11
  *         Contact Information:
  *         WeChat:	18610086859
  *         QQ:		1740415547
  *         Email: 18610086859@126.com
  *         Tel:	18610086859
  *         ΢�Ź����˺ţ�DT_Spark
  */

case class Person(name: String, isMale: Boolean, children: Person*)

object For_Expressive {

  def main(args: Array[String]) {
    val lauren = Person("Lauren", false)
    val rocky = Person("Rocky", true)
    val vivian = Person("Vivian", false, lauren, rocky)
    val persons = List(lauren, rocky, vivian)

    val result = persons filter (person => !person.isMale) flatMap (person =>
      (person.children map (child => (person.name, child.name))))
    println(result)

    val forResult = for (person <- persons; if !person.isMale; child <- person.children)
      yield (person.name, child.name)
    println(forResult)

  }

}