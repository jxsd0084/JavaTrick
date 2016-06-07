package crxy

object Test73 extends App {
  var t = (1, 2, 3)
  var (first, second, third) = t  // 模式匹配
  println(first)

  var s = "++"

  var result = s match {
    case "a" => println("超人")
    case "*" => 1
    case "牛人" => "superman"
    case _ if s.contains("=") => (x: Int) => {
      x + 1
    }
    case _ => 0
  }

  println(result)
}