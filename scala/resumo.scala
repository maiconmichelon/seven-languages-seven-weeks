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
