% Make a simple knowledge base. Represent some of your favorite
% books and authors.

livro(livro1, autor1).
livro(livro2, autor2).
livro(livro3, autor3).
livro(livro4, autor2).
livro(livro6, autor1).
livro(livro5, autor1).

livroDoAutor(X, Y) :- livro(Y, X).


instrumento(m1, guitarra).
instrumento(m1, baixo).
instrumento(m1, bateria).
instrumento(m2, violao).
instrumento(m2, gaita).
instrumento(m3, saxofone).

genero(m1, rock).
genero(m2, sertanejo).
genero(m3, jazz).

genero_instrumento(Genero, Y) :- genero(X, Genero), instrumento(X, Y).
