c(translate).
Pid = spawn(fun translate:loop/0).
Pid ! "casa".
% "house"
Pid ! "branca"
% "white"
Pid ! "aaa"
% "I don't understand."
