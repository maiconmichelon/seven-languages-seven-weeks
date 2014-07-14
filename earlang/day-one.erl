% Write a function that uses recursion to count to ten.
count(10) -> 10.
count(N) -> N, Count(N + 1).

count(0).

% Write a function that uses matching to selectively print “success”
% or “error: message” given input of the form {error, Message} or success .
printar({Error, Message}) -> Error + ": " + Message.
printar({"Error 404", "Not found"}). 
