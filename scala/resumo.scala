println("abc".size) // 4
println("abc" + 4) // abc4
println(4 + "1.0") // 41.0

val a = 1
val b = 2

if (a < b) {
  println("A é menor que B")
} else {
  println("A não é menor que B")
}

var c = 1
c = 2
println("Var é imutavel, val não")

// Alguns métodos e loops
def whileLoop {
  var i = 1
  while (i < 4) {
    println(i)
    i += 1
  }
}

whileLoop

def forLoop {
  for (i <- 0 until args.length) {
    println(args(i))
  }
}
forLoop

def forEach {
  args.foreach{ arg =>
    println(arg)
  }
}
forEach
// A cima mesma coisa que 'v.each {|arg| puts arg}'

var rangeUntil = 0 until 5 // Range(0, 1, 2, 3, 4)
var rangeTo = 0 to 5 // Range(0, 1, 2, 3, 4, 5)

println(rangeUntil.start) // 0
println(rangeUntil.end) // 4

rangeUntil = (0 until 5) by 2 // Vai de 0 até 5 de dois em dois (0, 2, 4)

println(rangeUntil.step) // 2
println(rangeTo.step) // 1

rangeUntil = 10 until 0 by -2 // (10, 8, 6, 4, 2)
println(rangeUntil.toString)

// Tuples é tipo um vetor
// Tuples tem tamanho fixo, suportam diferentes tipos de objetos

val person = ("Elvis", "Presley")
println(person._1) // Elvis
println(person._2) // Presley

// Tuples com atribuicao multivalorada,
var (x, y) = (2, 3) // estou setando as variaveis 'X' e 'Y'
println(x + " - " + y) // 2 - 3

// Classes
class Person(firstName: String, lastName: String)
val maicon = new Person("Maicon", "Michelon")

class Compasso {

  val direcoes = List("norte", "leste", "sul", "oeste")
  var rolamento = 0

  print("Rolamento inicial : ")
  println(direcao)

  def direcao() = direcoes(rolamento)

  def inform(turnDirection: String) {
    println("Virando para a " + turnDirection + ". Agora estamos na direção " + direcao)
  }

  def virarDireita() {
    rolamento = (rolamento + (direcoes.size + 1)) % direcoes.size
    inform("Direita")
  }

  def virarEsquerda() {
    rolamento = (rolamento + (direcoes.size - 1)) % direcoes.size
    inform("Esquerda")
  }

}

val meuCompasso = new Compasso
meuCompasso.virarDireita
meuCompasso.virarDireita

meuCompasso.virarEsquerda
meuCompasso.virarEsquerda
meuCompasso.virarEsquerda
meuCompasso.virarEsquerda
meuCompasso.virarEsquerda

def teste = "abc" // É um syntax sugar, quando é uma única linha.
println(teste) // Abc
def teste2 = println("abc")
teste2 // abc

// Construtores auxiliares
class Person2(first_name: String) {

  println("Outro construtor")

  def this(first_name: String, last_name: String) {
    this(first_name)
    println("Inner constructor")
  }

  def talk() = println("Hi")

}
val bob = new Person2("Bob")
val bobTate = new Person2("Bob", "Tate")

// métodos estaticos, ele adiciona o método na classe singleton
object Person {
  def hi = println("Hi static")
}
Person.hi

class Person3(val name: String) {
  def talk(message: String) = println(name + " says " + message)
  def id(): String = name // retorna o nome
}

class Employee(override val name: String, val number: Int) extends Person3(name) {
  override def talk(message: String) {
    println(name + " with number " + number + " says " + message)
  }

  override def id():String = number.toString // retorna o numero
}

val employee = new Employee("Yoda", 4)
employee.talk("Extend or extends not. There is no try")

// Traits - É um mixin de Ruby para Scala
trait Nice {
  def greet() = println("Howdily doodily.")
}

class Character(override val name:String) extends Person3(name) with Nice
val flanders = new Character("Ned")
flanders.greet // "Howdily doodily."

// Metodos
def double(x:Int): Int = x * 2
println(double(4)) // 8

def doubleMultiLine(x:Int):Int = {
  x * 2
}
println(double(3)) // 6

List(1, 2, 3) // List[Int](1, 2, 3)
List("a", "b", "c") // List[java.lang.String](a, b, c)
var lst  = List("a", 2, 3) // List[Any](a, 2, 3)
println(lst(1)) // 2
println(lst(0)) // a
// Nao funciona como o esperado rs
// println(lst(-4)) // a (Sempre que o numero for negativo, retornara o primeiro numero da lista)

// Sets
val animals = Set("lions", "tigers", "bears") // "lions", "tigers", "bears"
animals + "jacare" // "lions", "tigers", "bears", "jacare" (Para adicionar basta colocar + alguma coisa)
animals - "lions" // "tigers", "bears", "jacare" (Para remover mesma coisa)

// Para adicionar uma lista voce usa ++ e para remover --
animals ++ Set("Cachorro", "gato") // "tigers", "bears", "jacare", "cachorro", "gato"
animals -- Set("jacare", "tigers") // "bears", "cachorro", "gato''

println(Set(1, 2, 3) == Set(3, 2, 1)) // true
println(List(1, 2, 3) == List(3, 2, 1)) // false

// Maps
val map = Map(1 -> "um", 2 -> "dois", 3 -> "tres")
println(map(1)) // um

import scala.collection.mutable.HashMap
val hash = new HashMap[Int, String]
hash += 4 -> "quatro"
hash += 5 -> "cinco"
println(map) // Map(4 -> quatro, 8 -> oito)
// hash += "seis" -> 6 // Da erro, o tipo nao e valido

// Iterar sobre lista
lst.foreach(obj => println(obj)) // a, 2, 3
animals.foreach(obj => println(obj)) // lions, tigers, bears
hash.foreach(obj => println(obj)) // (4, quatro), (5, cinco)
hash.foreach(obj => println(obj._1 + " - " + obj._2)) // 4 - quatro, 5 - cinco

// Mais métodos de collections
println(lst.isEmpty) // false
println(Nil.isEmpty) // true
println(lst.length) // 3
println(lst.size) // 3
println(lst.head) // a
println(lst.tail) // 2, 3  (o resto, tirando o primeiro)
println(lst.last) // 3
println(lst.init) // a, 2 (o resto, tirando o ultimo)

println(lst.reverse) // 3, 2, a
println(lst)
println(lst.drop(1)) // 2, 3
println(lst.drop(3)) // vazio (o parametro é o numero de objetos que eu vo remover da lista)

val valores = List(1, 2, 5, 7, 8)
println(valores.count(v => v % 2 == 1)) // 3 (tres numeros impares)
println(valores.filter(v => v % 2 == 0)) // List(2, 8)
println(valores.map(v => v % 2)) // List(1, 0, 1, 1, 0, 1)
println(valores.forall(v => v > 0)) // true (todos sao maiores que zero)
println(valores.forall(v => v > 2)) // false
println(valores.exists(v => v > 0)) // true
println(valores.exists(v => v > 4)) // true

var sumlist = List("saasudhsau", "ssaehaauhaeu", "aa")
// Começa com 0, variaval sum é sempre a mesma que vai passando elemento por elemento
// e 'i' é o elemento
val letters = (0 /: sumlist) {(sum, i) => sum + i.size}
println(letters + " letras") // 24 letras
println(sumlist.foldLeft(0)((sum, value) => sum + value.length)) // 24

// XML
val movies =
<movies>
  <movie genero = "acao">Filme 1</movie>
  <movie genero = "comedia">Filme 2</movie>
</movies>

println(movies.text) // Filme 1 Filme 2
val movieNodes = movies \ "movie"
println(movieNodes(0)) // <movie genero = "acao">Filme 1</movie>
println(movieNodes(0) \ "@genero") // acao

// Pattern Matching
def doChore(chore: String): String = chore match {
  case "chave1" => "key1"
  case "chave2" => "key2"
  case _ => "outros"
}

println(doChore("chave1")) // key1
println(doChore("chave2")) // key2
println(doChore("chave3")) // outros

def fatorial(n: Int): Int = n match {
  case 0 => 1
  case x if x > 0 => { // X é o parametro (n)
    fatorial(n - 1) * n
  }
}
println(fatorial(0)) // 1
println(fatorial(3)) // 6

// Regular expression
val reg = """^(F|f)\w*""".r // chama m'etodo r que retorna um objeto regex
println(reg.findFirstIn("Fantastic")) // Some(Fantastic)
println(reg.findFirstIn("not Fantastic")) // None

val moviesM = <movies>
  <movie>The Incredibles</movie>
  <movie>WALL E</movie>
  <short>Jack Jack Attack</short>
  <short>Geri's Game</short>
</movies>

(moviesM \ "_").foreach { movie =>
  movie match {
    case <movie>{movieName}</movie> => println(movieName)
    case <short>{shortName}</short> => println(shortName + " (short)")
  }
}

// Concorrencia
import scala.actors._
import scala.actors.Actor._

case object Poke
case object Feed

class Kid() extends Actor {
  def act() {
    loop {
      react {
        case Poke => {
          println("Own...")
          println("Quit it...")
        }
        case Feed => {
          println("Gurgle...")
          println("Burp...")
        }
      }
    }
  }
}

val bart = new Kid().start
val lisa = new Kid().start
println("Ready to poke and feed")

// bart ! Poke
// lisa ! Poke
// bart ! Feed
// lisa ! Feed

// Clousure
val aoQuadrado = (x : Int) => x * x // Isto é uma clausure
val numeros = List(1, 2, 3, 4, 5)
println(numeros.map(aoQuadrado)) // List(2, 4, 9, 16, 25). O Map é um High-Order function, pois recebe como parametro
// uma funcao

var anyValue = 5
val sumAnyValue = (x : Int) => x + anyValue
println(numeros.map(sumAnyValue)) // List(6, 7, 8, 9, 10)
anyValue = 1
println(numeros.map(sumAnyValue)) // List(2, 3, 4, 5, 6), é Stateful, mantem um ponteiro para onde a clousure foi criada.

// Currying
// def met(x: Int)(y: Int) = x * y
// def test(x: Int, y : (x: Int) => Int): Int = y(x)
// println(test(2, met(3)))
// Primeiro executa met(3), que retorna uma funcao que recebe um parametro e multiplica o parametro por 3
// def method(x: Int) = x * 3
// Segundo, chama o método teste passando o parametro, dentro da funcao teste ele executa o 'method' passando como
// parametro 2.
// O resultado é 2 * 3 , Seis.
