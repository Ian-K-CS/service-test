def digit(n: Long) = {
  n.toString.reverse.split("").map(_.toInt)
}
digit(23423423L)
println(digit(23423423L).mkString)

Array(1,2,3,4,5)
println(Array(1,2,3,4,5))
println(Array(1,2,3,4,5).mkString)
println(List(1,2,3,4,5))


"hello there".split(" ")
val x = "hello there".split(" ").map(_.head.toUpper)
x(0) + "." + x(1)
"hello there".split(" ").map(_ + " more string to add").flatten
"hello there".split(" ").flatMap(_ + " more string to add")

def abbrevname(name: String) = {
  val s"$x $y" = name.toUpperCase()
  s"$x"
//  s"${x.head} ${y.head}"
}

abbrevname("james smith")

"sddsfsdfdsf"(0)

List(1,2,3,4,5).toString
List(1,2,3,4,5).mkString


def lovefunc(f1: Int, f2: Int): Boolean = {
  if (f1 != f2) true else false
}
lovefunc(2, 2)


val aSome: Option[Int] = Some(100)
aSome.map(x => x + 100)

val optionOption: Option[Option[Int]] = aSome.map(x => Some(x + 100))
optionOption.flatMap(x => x.map(y => y)) // why isn't this flattened?




val numList = List(1, 2, 3)
val letterList = List("a", "b", "c")

val forTest: Seq[String] = for {
  num <- numList
  if num >= 3
  char <- letterList
} yield s"$num-$char"
forTest















def invert(list: List[Int]): List[Int] = {
  list.map(x => if (x > 0) -x else -x)
}

invert(List(1,2,3,4,5))
invert(List(1,-2,3,-4,5))


def getCount(s: String): Int = {
  s.count("aeiou".contains(_))
}
getCount("iuhfdiosdmvkmfamjbnes;cmclcm,saxken")


def disemvowel(str: String):String = {
  str.filterNot(char => "aeiou".contains(char.toLower))
}
disemvowel("aetA")


def squareDig(n: Int) = {
//  n.toString.split("").map(x => x.toInt * x.toInt).mkString.toInt
  n.toString.map(_.asDigit)
  n.toString.map(_.toInt) // why isn't this (9, 1) and returns (57, 49)
}
squareDig(91)


def minAndMax(str: String) = {
  val stringToArrayInt: Array[Int] = str.split(" ").map(_.toInt)
  s"${stringToArrayInt.max} ${stringToArrayInt.min}"
}
minAndMax("1 2 3 4 5 -4")

Option(42)
Some(42)
Some(None)












// for comprehension test (Paul - Ian)
val paul: Option[String] = Some("Paul")
val deadPaul: Option[String] = None
val todd: Option[String] = Some("Todd")
val president: Option[String] = Some("Biden")

val upperPaul = paul.map(x => x.toUpperCase).map(_.reverse)

println(upperPaul)
println(deadPaul)

private val concatenated = for {
  paulsValue <- upperPaul //  upperPaul.map(x => x)
  todd <- todd
  normalPaul <- deadPaul
  theDon <- president
} yield paulsValue + todd + normalPaul + theDon

val concatenated2 = upperPaul.flatMap(paul => todd.map(toddo => toddo ++ paul) )

println(concatenated)
println(concatenated2)






