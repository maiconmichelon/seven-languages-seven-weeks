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
		if ( value type == "Number", tot := tot + value, tot := tot + value.sum ))
	return tot
);

list(
    list( 1, 2, 3 ),
    list( 10, 30 ),
    list( 100, 200 )
) sum println;
