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
