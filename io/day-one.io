// Evaluate 1 + 1 and then 1 + "one". Is Io strongly typed or weakly
// typed? Support your answer with code.

1 + 1 println
// 1 + "one" println > da pau falando que "onde" deve ser um Number e não um sequence

// Is 0 true or false? What about the empty string? Is nil true or false?
if (0, "Zero é verdadeiro" println, "Zero é falso" println)

// How can you tell what slots a prototype supports
Teste := Object clone
Teste slotTeste := "um slot qualquer"
Teste slotNames println // (slotTeste, type)

// What is the difference between = (equals), := (colon equals), and ::= (colon colon equals)? 
// When would you use each one

// =  >> atribui o valor, caso o slot não esteja criado vai estourar exceção
// :=  >> cria o slot e atribui o valor
// ::=   >> Cria um slot, cria o setter e atribui o valor


// Run an Io program from a ﬁle.
// Pra rodar é só :
// Io esteArquivo.io




