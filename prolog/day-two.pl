% Reverse the elements of a list.

inverter([], []).
inverter([A], [A]).
inverter(Retorno, [Head|Tail]) :- inverter(List, Tail), append(List, [Head], Retorno).

% Find the smallest element of a list.
menor(Men, [Men]).
menor(Men, [Head|Tail]) :- menor(TailMenor, Tail), Men is min(Head, TailMenor).

