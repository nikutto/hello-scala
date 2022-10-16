

trait Animal:
    def speak(): String

class Person(val name: String) extends Animal:
    override def speak(): String = Person.MESSAGE
    def this(firstName: String, secondName: String) = this(s"$firstName $secondName")

object Person:
    val MESSAGE = "Hello!"

class Cat extends Animal:
    override def speak(): String = "Meow!"

object StringUtils:
    val EMPTY = ""
    def concatenate(a: String, b: String) = a + b    

abstract class Person2(val name: String):
    def getHello(): String

class Japanese(name: String) extends Person2(name):
    override def getHello(): Predef.String = "Konichiwa"

enum ItemType:
    case Food
    case Cloths
    case Other

case class Item(name: String, price: Int, typ: ItemType)

class DomainModelingSuite extends munit.FunSuite {
    test("class") {
        val p = Person("John")
        assertEquals(p.name, "John")
    }
    test("traits") {
        val a: Animal = Person("John")
        assertEquals(a.speak(), "Hello!")
    }

    test("aux constructor") {
        val p = Person("James", "Bond")
        assertEquals(p.name, "James Bond")
    }

    test("named") {
        val p = Person(name = "Bob")
        assertEquals(p.name, "Bob")
    }

    test("object") {
        assertEquals(StringUtils.concatenate("a", "bc"), "abc")
        assertEquals(StringUtils.EMPTY, "")
    }

    test("abstract") {
        val p: Person2 = Japanese("Ken")
        assertEquals(p.getHello(), "Konichiwa")
    }

    test("enum") {
        val itemType = ItemType.Food
        itemType match
            case ItemType.Cloths => assert(false)
            case ItemType.Food => assert(true)
            case ItemType.Other => assert(false)
    }

    test("case class") {
        val item = Item("niku", 100, ItemType.Food)
        assertEquals(item.name, "niku")
        val newItem = item.copy(price = 3000)
        assertEquals(newItem.price, 3000)
    }
}