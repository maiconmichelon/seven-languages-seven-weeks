2 + 2.
% 4

2 + 2.0.
% 4.0

"string".
% string

[1, 2, 3].
% string

[72, 97, 32, 72, 97, 32, 72, 97].
% Ha Ha Ha

Variavel = 5.
% variavel sempre comeca com letra maiuscula

% Variavel = 6
% acima nao funciona, todas as variaveis são imutaveis

VariavelSimbolo = simbolo.
% este é um simbolo

VariavelSimbolo.
% simbolo

Lista = [1, 2, 3].
Tupla = {1, 2, 3}.

%Pattern matching
Pessoa = {pessoa, {nome, "Maicon"}, {sobrenome, "Michelon"}}.
{pessoa, {nome, Nome}, {sobrenome, Sobrenome}} = Pessoa.
Nome.
% "Maicon"
Sobrenome.
% "Michelon"

[Head | Tail] = [1, 2, 3].
Head.
% 1
Tail.
% [2, 3]

[Um, Dois, Tres | Resto] = [1, 2, 3, 4, 5, 6]
Um.
% 1
Tres.
% 3
Resto.
% [4, 5, 6]

% CASE
Animal = "cachorro"
case Animal of
  "gato" -> cat
  "cachorro" -> dog
  _ -> other
end.
Animal.
% dog

% IF
X = 0
if
  X < 0 -> negativo;
  X > 0 -> positivo;
  true -> zero;
  % Ao menos uma condicao tem que ser verdadeira, senao da erro
end.
X.
% zero

% Higher-order functions (funcoes que recebem funcoes ou retornam funcoes)
Negativar = fun(I) -> -I end.
% a keyword 'fun' significa que estamos definindo uma funcao anonima

Negativar(1)
% -1
Negativar(-1)
% 1

Numbers = [1, 2, 3, 5].
Func = fun(Number) -> io:format("~p~n", [Number]) end.
lists:foreach(Func, Numbers).
% 1
% 2
% 3
% 5
% ok

lists:map(fun(Number) -> n * 2 end, Numbers).
% [2, 4, 9, 25]

Small = fun(Number) -> Number < 3 end.
lists.filter(Small, Numbers).
% [1, 2]

lists:all(Small, [1, 2]).
% true, verifica se todos os elementos satisfazem a condicao
lists:all(Small, [1, 2, 3]).
% false

lists:any(Small, [1, 2, 3]).
% true. Verifica se pelo menos um elemento satisfaz a condicao
lists:any(Small, [5, 6, 7]).
% false, nenhum elemento satisfaz

lists:any(Small, []).
% false, nao existe pelo menos um elemenot que satisfaz a condicao
lists:all(Small, []).
% true, todos os elementos da lista satisfazem a condicao, mesmo nao havendo itens

lists:takewhile(Small, [1, 2, 3, 4]).
% [1, 2], mantenha enquanto for menor que tres
lists:dropwhile(Small, [1, 2, 3, 4]).
% [3, 4], remova enquanto for menor que tres

% FOLDL
Numbers.
% [1, 2, 3, 4]
lists:foldl(func(X, Sum) -> X + Sum end, 0, Numbers).
% 10, funcao, funcao onde X eh o numero e sum eh o acumulador. 0 eh o numero inicial e Numbers o array

% simplificando...
Adder = fun(ListItem, Sum) -> ListItem + Sum.
InitialSum = 0.
lists.foldl(Adder, InitialSum, Numbers).

% Comprehensions

% alternativa ao map
Double = fun(X) -> X * 2 end.
[Double(X) || X <- [1, 2, 3]].
% [2, 4, 6], chame a funcao Double para cada elemento da lista
