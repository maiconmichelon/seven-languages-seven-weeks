(println "Give me some Clojure!")
(println (+ 2 2 2)) ; 6
(println (mod 5 4)) ; 1
(println (/ (/ 8 2) (/ 4 2))) ; 2
(println (/ (/ 6 2) (/ 4 2))) ; 3/2
(println (< 1 2 3 4)) ; true
(println (< 1 2 5 3)) ; false
(println (str "um, " "dois, " " e tres")) ; um, dois e tres
(println (str \f \o \r \c \e)) ; force
(println (= "a" \a)) ; false
(println (= ""))
(println (class true)) ; java.lang.Boolean
(if (> 2 1) (println "dois é maior que um") (println "dois é menor que um")) ; dois é maior que um
(if false (println "true") (println "false")) ; false
(if 0 (println "true")) ; true
(if nil (println nil)) ; nil
(if "" (println "true")) ; true

; Listas
(println (list 1 2 3)) ; (1, 2, 3), obs: mesma coisa que '(1, 2, 3)
(println (first '(1 2 3))) ; 1
(println (last '(1 2 3))) ; 3
(println (rest '(1 2 3))) ; (2 3)
(println (cons :cons '(1 2 3))) ; aqui mescla os elementos. (:cons 1 2 3)

; vetores
(println [:ele1 :ele2 :ele3]) ; [:ele1 :ele2 :ele3]
(println (first [:ele1 :ele2 :ele3])) ; :ele1
(println (last [:ele1 :ele2 :ele3])) ; :ele3
(println (nth [:ele1 :ele2 :ele3] 1)) ; :ele2
(println ([:ele1 :ele2 :ele3] 2)) ; :ele3
(println (concat [:ele1] [:ele2])) ; (:ele1 :ele2) . Mescla criando uma lista
(println (rest [:ele1 :ele2 :ele3])) ; (:ele2 :ele3)

; Sets
(def setzin #{:ele1 :ele3 :ele2}) ; atribuindo um set a uma variavel qualquer
(println setzin) ; #{:ele1 :ele3 :ele2}
(println (count setzin)) ; 3
(println (sort setzin)) ; (:ele1 :ele2 :ele3)
(println (sorted-set 2 3 1)) ; #{1 2 3}
(println (clojure.set/union #{:ele1} #{:ele2})) ; #{:ele1 :ele2}
(println (clojure.set/difference #{1 2 3} #{2})) ; retorna o que é diferente de dois. #{1 3}
(println (setzin :ele1)) ; :ele1
(println (setzin :ele4)) ; nil
(println {:um :one :dois :two}) ; {:um :one, :dois :two}
(def translat {:um :one :dois :two})
(println (translat :um)) ; one
(println (merge {:um :one} {:dois :two})) ; {:um :one, :dois :two}
(println (merge-with + {:num1 1} {:num2 5} {:num1 3})); ; {:num2 5, :num1 4}. somou o 3 com 1
(println (assoc {:um :one} :quatro :four)) ; {:quatro :four, :um :one}
(println (sorted-map 1 :one 3 :three 2 :two)) ; {1 :one, 2 :two, 3 :three}

; Functions
(defn force-it [] (str "uma funcao" " qualquer"))
(println (force-it)) ; uma funcao qualquer
(defn force-it-with-description
  "Uma descrição qualquer para a função"
  []
  (str "uma funcao" " qualquer")
)
(println (doc force-it-with-description))
;-------------------------
;user/force-it-with-description
;([])
;  Uma descrição qualquer para a função
;nil

(defn force-it[parametro] (str "olá " parametro))
(println (force-it "Mundo")) ; olá Mundo

; Binding
(def variavel [[1 2][3 4]])
(println variavel) ; [[1 2][3 4]]
(defn line-end [ln] (last ln)) ; o ultimo elemento do ln (lista passada pelo parametro)
(println (line-end variavel)) ; [3 4]
(defn line-end [[[_ _] [second _]]] second) ;
(println (line-end variavel)) ; 3
(def board [[:x :o :x] [:o :y :o] [:o :x :o]])
(defn centro [ [_ [_ x _] _] ] x)
(println (centro board)) ; :y
; da pra simplificar
(defn centro [[_ [_ x]]] x)
(println (centro board)) ; :y

(defn center [board] (let [[_ [_ c]] board] c))
(println (centro board)) ; :y

(def person {:name "Jabba" :profession "Gangster"})
(let [{name :name} person] (str "The person's name is " name)) ; The person's name is Jabba

; High-order-functions
(def people ["Lea", "Han Solo"])
(defn contador-ao-dobro [x] (* 2 (count x)))
(println (map contador-ao-dobro people)) ; (6 16)

; da pra fazer direto mesmo
(println (map (fn [x] (* 2 (count x))) people)) ; (6 16)
; ou assim
(println (map #(* 2 (count %)) people)) ; (6 16) o % é o item corrente é o igual o [x] de cima

(def v [3 1 2])
(println (apply + v)) ; 6
(println (apply max v)) ; 3
(println (filter odd? v)) ; 1 3
(println (filter #(< % 3) v)) ; 1 2

; Recursao
(defn size[v]
  (if (empty? v)
    0
    (inc (size (rest v)))
  )
)
(println (size [1 2 3 4])) ; 4

(defn size[v]
  (loop [l v, c 0] ; c é um contador, v nunca irá mudar e l vai se desintegrando, (2 3 4) dpeois (2 3) deps (2)...
    (if (empty? l) ; se o vetor for vazio
      c ; retorna c que é o contador
      (recur (rest l) (inc c)) ; caso nao esteja vazio retorna para o LOOP, e não para a função,
  ; e o inc c, incremenda a variavel c, se é 3 vira 4 ...
    )
  )
)
(println (size [2 3 4])) ; 3

; Tests
(every? number? [1 2 3 :four]) ; false
(some nil? [1 2 nil]) ; true
(not-every? odd? [1 3 5]) ; false
(not-any? number? [:one :two :three]) ; true

; Changing Sequence
(def words ["luke", "chewbie", "han", "lando"])
(println (filter (fn [word] (> (count word) 4)) words)) ; ("chewbie", "lando")
(println (map (fn [x] (* x x)) [1 2 3 4])) ; (1 4 9 16)

(def colors["red" "green" "white"])
; tipo um foreach
(println (for [x colors] (str "I like " x))) ; (I like red I like Green I like white)
(def toys["car" "block"])
(println (for[x colors, y toys] (str "I like " x " " y)))
; (I like red car I like red block I like green car I like green block I like white car I like white block)

(defn menorQuatroCaracteres? [x] (< (count x) 4))
(println (for[x colors, y toys, :when (menorQuatroCaracteres? y)] (str "I like " x " " y)))
; (I like red car I like green car I like white car)
; clause When, somente quando a varivel y tiver menos que 4 chars

(println (reduce + [1 2 3 4])) ; 10
(println (sort [4 1 3 2])) ; (1 2 3 4)

; com high order
(defn abs[x] (if (< x 0) (- x) x))
(println (sort-by abs [-1 -4 2 3])) ; (-1 2 3 -4)

; Ranges
(println (range 1 5)) ; 1 2 3 4 5
(println (range 1 5 2)) ; 1 3 5
(println (range 10)) ; 0 1 2 3 4 5 6 7 8 9

; Sequencias infinitas e takes
(println (take 3 (repeat "Use a força"))) ; ("Use a força", "Use a força", "Use a força")
(println (take 5 (cycle [:lather :rinse :repeat]))) ; (:lather :rinse :repeat :lather :rinse)
(println (take 5 (drop 2 (cycle [:lather :rinse :repeat])))) ; (:repeat :lather :rinse :repeat :lather)
; acima, começando pelo terceiro, pulando os dois primeiros

; Assim tambem funciona...
(println (->> [:lather :rinse :repeat] (cycle) (drop 2) (take 5))) ; transforma num ciclo, pula para o terceiro
; elemento e começa do terceiro elemento, depois volta pro primeiro, segundo e terceiro, até passar 5 elementos.
; (:repeat :lather :rinse :repeat :lather)

; Colocando algo entre cada troca de posiçao
(println (take 5 (interpose :and (cycle [:lather :rinse :repeat]))))
; (:lather :and :rinse :and :repeat); a cada elemento ele coloca ' :and ' , graças ao interpose

; Posso tambem fazer um cycle sobre dois ranges, pulando de um pro outro
(println (take 20 (interleave (cycle (range 1 3)) (cycle (range 4 6)))))
; (:repeat :lather :rinse :repeat :lather)

; Se eu nao coloco o take, ele continua rodando, então da pra fazer o cycle de 1 até o infinito
; sendo que ele funciona em lazy, não carregando tudo de uma vez.

(println (take 5 (iterate inc 1))) ; (1 2 3 4 5)
(println (take 5 (iterate dec 0))) ; (0 -1 -2 -3 -4)

; Fibonacci
(defn fib-pair[[x y]] [y (+ x y)])
(println (fib-pair [1 1])) ; (1 2)
(println (take 5(map first (iterate fib-pair[1, 1]))))
; 1 1 2 3 5

; Protocolos
(defprotocol Compass
  (direction [c])
  (left [c])
  (right [c])
)

(def directions [:north :east :south :west]) ; criando um vetor para armazenar direcoes
(defn turn [base amount]
  (rem (+ base amount) (count directions))
)

(println (turn 1 1)) ; 2 - Estou na posicao 90, girando 90 graus vai pra posicao 180
(println (turn 3 1)) ; 0 - Estou na posicao 270, girando 90 vai pra posicao 360 que é 0
(println (turn 2 3)) ; 1 - Estou na posicao 180, girando 270 vai pra 470 que é 90

(defrecord SimpleCompass[bearing] Compass
  (direction [_] (directions bearing))
  (left[_] (SimpleCompass. (turn bearing 3))) ; Aqui cria um novo objeto passando como parametro o retorno do turn
  (right[_] (SimpleCompass. (turn bearing 1))) ; Sempre retorna um novo objeto, já que tudo é imutavel.

  Object
  (toString [this] (str "[" (direction this) "]")) ; Sobscrevendo o método toString

)

(def c (SimpleCompass. 1)) ; Cria uma instancia de SimpleCompass, com o bearing em 1
(println (left c)) ; #:user.SimpleCompass{:bearing 0}
(println (left c)) ; #:user.SimpleCompass{:bearing 0}
; Ta a mesma coisa pois a variavel é imutavel, só vai mudar se eu amazenar o retorno em outra variavel
(def retorno (left c))
(println (left retorno)) ; #:user.SimpleCompass{:bearing 3}

(defmacro unless[condicao bloco] (list 'if (list 'not condicao) bloco))
(unless true (println "unless true"))
; Macros servem para adicionar coisas na linguagem, quero adicionar um unless ... qualquer coisa do tipo
; É extender a linguagem

; References
(def movie (ref "Referencia qualquer"))
(println movie) ; #<Ref@61250ff2: Referencia qualquer>
(println (deref movie)) ; Referencia qualquer
(println @movie) ; Referencia qualquer

(dosync (alter movie str ": Nova referencias")) ; alterando o valor da referencia
(println movie) ; #<Ref@5a940f82: Referencia qualquer: Nova referencias>
(println @movie) ; Referencia qualquer: Nova referencias
(dosync (ref-set movie ": Nova referencias")) ; setando uma nova referencia
(println @movie) ; ": Nova referencias"

; Atom
(def danger(atom "Atom qualquer"))
(println danger) ; #<Atom@318efaea: Atom qualquer>
(println @danger) ; Atom qualquer
(reset! danger "Outra descricao")
(println @danger) ; Outra descricao
(println danger) ; #<Atom@318efaea: Outra descricao>

; Atom cache
(defn get[cache key] (@cache key)) ; funcao para pegar do map(cache) com a chave(key)
(defn put([cache value-map] (swap! cache merge value-map)) ([cache key value] (swap! cache assoc key value)));2 funcoes
(def ac (atom{})) ;; criando um map
(put ac :quote "Sou seu pai, Luke.")
(println (str "Cached item: " (get ac :quote))) ; Cached item: Sou seu pai, luke

; Future
(def finer-things (future (Thread/sleep 5000) "take time"))
(println @finer-things)
