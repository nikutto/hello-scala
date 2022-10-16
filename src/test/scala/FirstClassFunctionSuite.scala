
class FirstClassFunctionSuite extends munit.FunSuite {

    test("method chain") {
        val lst = 1 to 10
        val hoge = lst
            .filter(_ % 2 == 0)
            .map(_ * 2)
            .fold(0)((sum, v) => sum + v)
        assertEquals(hoge, 60)
    }
}