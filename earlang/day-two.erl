% Consider a list of keyword-value tuples, such as [{erlang, "a func-
% tional language"}, {ruby, "an OO language"}] . Write a function that ac-
% cepts the list and a keyword and returns the associated value for
% the keyword.
% • Consider a shopping list that looks like [{item quantity price}, ...] .
% Write a list comprehension that builds a list of items of the form
% [{item total_price}, ...] , where total_price is quantity times price .

ListaExerc = [{erlang, "a functional language"}, {ruby, "an OO language"}].
[Description || {Name, Description} <- ListaExerc].
% ["a functional language", "an OO language"]

Prieces = [{shoes, 2, 40.0}, {coat, 5, 32.00}, {skirt, 10, 19.90}].
[{Description, Quantity * Priece} || {Description, Quantity, Priece} <- Prieces].
% [{shoes, 80.0}, {coat, 160.00}, {skirt, 199.00}]
