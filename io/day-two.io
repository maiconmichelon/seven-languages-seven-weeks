// A Fibonacci sequence starts with two 1s. Each subsequent num-
// ber is the sum of the two numbers that came before: 1, 1, 2, 3,
// 5, 8, 13, 21, and so on. Write a program to find the nth Fibonacci
// number. fib(1) is 1, and fib(4) is 3. As a bonus, solve the problem
// with recursion and with loops.

nth := 5
fib := list(1, 1)

fibonacci := method(n,
	if (n == 1 or n == 2, return 1,
		for(i, 3, n, fib append(fib at(i-3) + fib at(i-2)))
		return fib at(n - 1))
)

fibonacci(nth) println

// How would you change / to return 0 if the denominator is zero?
Number setSlot(
	"coreDivision", 
	Number getSlot("/")
);

Number setSlot(
    "/",
    method(denominador, return if (denominador == 0, 0, self coreDivision(denominador)))
);

(0 / 0) println

// Write a program to add up all of the numbers in a two-dimensional array.
List sum := method(
	tot := 0
	// faz um foreach na lista
	self flatten() foreach(index, value, 
		// Se o valor for um número ele adiciona caso não, é uma lista, então faz uma chamada recursiva com a lista
		if ( value type == "Number", tot := tot + value, tot := tot + (value sum)))
	return tot
);

lst := list(
    1, 7, 
    // "a",
    list( 1, 2, 3 ),
    list( 10, 30 ),
    list( 100, 200 )
);
"Soma " print
lst sum println

// Add a slot called myAverage to a list that computes the average of
// all the numbers in a list. What happens if there are no numbers
// in a list? (Bonus: Raise an Io exception if any item in the list is not
// a number.)
List setSlot("media",
	method(
		tot := 0
		count := 0
		self foreach(index, value,
			if ( value type == "Number", 
				tot := tot + value; count := count + 1, 
				if ( value type == "List", 
					tot := tot + (value sum); count := count + value size, 
					Exception raise("List must have only numbers.")))
		)
		return tot / count;
	)
)
"Média " print
lst media println

// Write a prototype for a two-dimensional list. The dim(x, y) method
// should allocate a list of y lists that are x elements long. set(x, y,
// value) should set a value, and get(x, y) should return that value.
Matriz := Object clone
Matriz create := method(x, y,
	self lists := list; // Cria uma lista
	for (i, 1, x, lists push(list() setSize(y))); // dentro de cada list cria outra lista 
);
Matriz set := method(x, y, value,
	self lists at(x) atPut(y, value); 
);
Matriz get := method(x, y,
	self lists at(x) at(y);
);

lst := Matriz clone;
lst create(3, 2);
lst println

lst set(0, 0, 2);
lst set(0, 1, "a");
lst set(1, 0, "b");
lst set(1, 1, "c");
lst println

lst get(0, 1) println // a

// Bonus: Write a transpose method so that (new_matrix get(y, x)) ==
// matrix get(x, y) on the original list.
Matriz copiar := method(
	copia := self clone; // Clona uma matriz
	copia create(lists size, lists at(0) size); // Cria uma matriz com o mesmo tamanho 
	for (i, 0, lists size - 1, // Itera sobre a lista principal
		for (y, 0, lists at(0) size - 1, // Itera sobre a lista secundaria
			copia set(i, y, self get(i, y)); // Seta os valores
		)
	)
	return copia;
)
copia := lst copiar;

// Write the matrix to a file, and read a matrix from a file
Matriz write = method(fileName, 
	file := File open(fileName);
	for (i, 0, lists size -1, 
		for (y, 0, lists at(0) size -1,
			file write(self get(i, y) asString);
			file write(" ");
		);
		file write("\n");
	);
	file close;
);
copia write("/home/maicon/matriz");
"O arquivo /home/maicon/matriz foi criado";

// Write a program that gives you ten tries to guess a random number
// from 1–100. If you would like, give a hint of “hotter” or “colder”
// after the first guess.
random := Random value(100) ceil
ultimo := -1;
atual := -1;

random println

input := File standardInput()
while (true,
	atual := input readLine asNumber;
	if (atual == random, "Muito bem vocë acerto !!" println; break;)
	if (atual == (1 negate), 
		"Tente novamente",
		difU := (random - ultimo) abs;
		difA := (random - atual) abs;
		if (difU < difA, "Esfriou!" println, "Esquentou!" println);
	);
	ultimo := atual;
)


