valido([]).
valido([Head|Tail]) :-
	fd_all_different(Head),
	valido(Tail).

resolver(Sudoku, Solucao) :- 
	Solucao = Sudoku,
	Sudoku = [S11, S12, S13, S14,
		S21, S22, S23, S24,
		S31, S32, S33, S34,
		S41, S42, S43, S44],

	fd_domain(Sudoku, 1, 4),
	
	Linha1 = [S11, S12, S13, S14],
	Linha2 = [S21, S22, S23, S24],
	Linha3 = [S31, S32, S33, S34],
	Linha4 = [S41, S42, S43, S44],
	
	Coluna1 = [S11, S21, S31, S41],
	Coluna2 = [S12, S22, S32, S42],
	Coluna3 = [S13, S23, S33, S43],
	Coluna4 = [S14, S24, S34, S44],

	Quadrado1 = [S11, S12, S21, S22],
	Quadrado2 = [S13, S14, S23, S24],
	Quadrado3 = [S31, S32, S41, S42],
	Quadrado4 = [S33, S34, S43, S44],
	
	valido([Linha1, Linha2, Linha3, Linha4, 
		Coluna1, Coluna2, Coluna3, Coluna4,
		Quadrado1, Quadrado2, Quadrado3, Quadrado4]).
