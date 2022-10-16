
class VariableAndDataTypesSuite extends munit.FunSuite {
    test("val") {
        val a = 0
        assertEquals(a, 0)
    }

    test("var") {
        var b = 1
        assertEquals(b, 1)
        b = 2
        assertEquals(b, 2)
    }

    test("types") {
        val b: Byte = 1.toByte
        val i: Int = 1
        val l: Long = 1L
        val s: Short = 1.toShort
        val d: Double = 2.0
        val f: Float = 1.2f
        val bi = BigInt(1_000_000_000)
        val bd = BigDecimal(1.2345)

        val msg: String = "String"
        val c: Char = 'A'
    }

    test("string interpolation") {
        val name = "Bob"
        assertEquals(s"Hello, $name", "Hello, Bob")
        assertEquals(s"${2+3}", "5")
    }

    test("multiline strings") {
        val quote: String = """This is Tom.
                            |Hello world!""".stripMargin
        val expected = "This is Tom.\nHello world!"
        assertEquals(quote, expected)
    }

}