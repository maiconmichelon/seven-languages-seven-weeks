;; Implement a function called (big st n) that returns true if a string st
;; is longer than n characters

(defn big[st n] (> (count st) n))
(println (big "maicon" 4))
(println (big "maicon" 7))
