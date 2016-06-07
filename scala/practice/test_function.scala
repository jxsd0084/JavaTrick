package practice

object test_function {

  def function(n: Int): Int = {
    var multi = (a: Int, b: Int) => a * b
    multi.apply(n, 2)
  }

  def main(args: Array[String]): Unit = {
    println("test_function")
    println(function(2));
    println(function(3));
    println(function(4));
  }

}