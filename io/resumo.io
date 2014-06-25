"Hi ho, IO" println

Veiculo := Object clone 
//Clona um objeto

Veiculo descricao := "Something"
// atribui "Something" ao slot descricao do objeto veiculo
// := é para quando não existe certeza se o objeto já existe
// Se eu usar somente '=' ele vai funcionar somente quando o objeto já existir
// Caso Veiculo não exista ainda ele vai estourar erro

Veiculo descricao = "Other"
// agora funciona porque declarei ali em cima

Veiculo descricao println
// retorna "Other"

Veiculo slotNames println
// retorna list("type", "description")

Veiculo type println
// retorna "Veiculo" 

Object type println
// retorna "Object"

Car := Veiculo clone println
// Cria um modelo car, modelo é um objeto, mas nem todo objeto é um modelo
// por convesao IO todos os modelos comecam com letra maiuscula
// quando é um modelo ele tem o slot 'type' como o nome do modelo

Car slotNames println
// retorna type

Car type println
// retorna Car

ferrari := Car clone
// clona um carro

ferrari slotNames println
// retorna uma lista vazia

ferrari type println
// retorna Car
// Caso ele nao encontrar um slot com o nome no objeto ele vai subindo na herança
// até encontrar algum objeto que satisfaça a chamada

Ferrari := Car clone
// clona um carro

Ferrari type println
// Ferrari

Ferrari slotNames println
// list(type)

ferrari slotNames println
// list()

// um é um modelo e outro não

method("print algo" println)
// cria um método que faz o print de print algo.

// Método recursivo
rec := method(n, if (n == 0, "é zero" println 
			     return rec(2), 
                             return -1))
rec(0) println

