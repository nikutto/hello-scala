import java.io.IOException

class ControlStructuresSuite extends munit.FunSuite {

  test("if/else") {
    def getSignString(x: Int) = if x < 0 then "negative"
    else if x == 0 then "zero"
    else "positive"
    assertEquals(getSignString(1), "positive")
    assertEquals(getSignString(-1), "negative")
  }

  test("for loops") {
    val ints = List(1, 2, 3)
    var sum = 0
    for i <- ints do sum += i
    assertEquals(sum, 6)
  }

  test("guards") {
    val ints = List(1, 2, 3)
    var sum = 0
    for
      i <- ints
      if i % 2 == 0
    do sum += i
    assertEquals(sum, 2)
  }

  test("nest for") {
    var sum = 0
    // (i, j) = (2, 4), (2, 6)
    for
      i <- 1 to 3
      j <- 4 to 6
      if i % 2 == 0
      if (i + j) % 2 == 0
    do sum += i * j
    assertEquals(sum, 20)
  }

  test("for expression") {
    val ints = for i <- 1 to 4 yield i
    var sum = 0
    for i <- ints do sum += i
    assertEquals(sum, 10)
  }

  test("match expression") {
    val i = 1
    val msg = i match
      case 1 => "One"
      case 2 => "Two"
      case _ => "Other"
    assertEquals(msg, "One")
  }

  test("match tuple") {
    val tup = (1, 5)
    val msg = tup match
      case (x, y) if x == 1 => "OK"
      case _                => "NG"
    assertEquals(msg, "OK")
  }

  test("match tuple2") {
    val tup = (1, 5)
    val msg = tup match
      case (1, y) => "OK"
      case _      => "NG"
    assertEquals(msg, "OK")
  }

  test("matchable") {
    def getMsg(x: Matchable) = x match
      case i: Int                        => "Int"
      case s: String if s.contains("NO") => "Bad String"
      case s: String                     => "String"
      case l: List[_]                    => "List"
      case _                             => "_"
    assertEquals(getMsg("string"), "String")
    assertEquals(getMsg(List(1, 2)), "List")
  }

  test("try/catch/finally") {
    def f(flag: Boolean): Int =
      var sum = 0
      try
        sum += 1
        if flag then throw IllegalStateException("Oh my god!")
        sum += 100
      catch
        case ioe: IOException           => sum += 200
        case ise: IllegalStateException => sum += 2
        case e: Exception               => sum += 400
      finally sum += 4
      return sum
    assertEquals(f(false), 105)
    assertEquals(f(true), 7)
  }

  test("while") {
    var x = 3
    var sum = 0
    while x >= 0 do
      sum += x
      x -= 1
    assertEquals(sum, 6)
  }

}
