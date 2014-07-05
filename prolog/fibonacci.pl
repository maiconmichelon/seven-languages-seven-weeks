fib(0, 0).
fib(1, 1).
fib(Posicao, Numero) :- 
	Posicao > 1,
	PosUltimo is Posicao - 1,
	fib(PosUltimo, ValorUltimo),
	PosPenultimo is Posicao - 2,
	fib(PosPenultimo, ValorPenultimo),
	Numero is ValorUltimo + ValorPenultimo.
