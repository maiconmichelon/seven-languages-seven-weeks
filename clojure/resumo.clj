(println "Give me some Clojure!")
(println (+ 2 2 2)) ;; 6
(println (mod 5 4)) ;; 1
(println (/ (/ 8 2) (/ 4 2))) ;; 2
(println (/ (/ 6 2) (/ 4 2))) ;; 3/2
(println (< 1 2 3 4)) ;; true
(println (< 1 2 5 3)) ;; false
(println (str "um, " "dois, " " e tres")) ;; um, dois e tres
(println (str \f \o \r \c \e)) ;; force
(println (= "a" \a)) ;; false
(println (= ""))
(println (class true)) ;; java.lang.Boolean
(if (> 2 1) (println "dois é maior que um") (println "dois é menor que um")) ;; dois é maior que um
(if false (println "true") (println "false")) ;; false
(if 0 (println "true")) ;; true
(if nil (println nil)) ;; nil
(if "" (println "true")) ;; true

;; Listas
(println (list 1 2 3)) ;; (1, 2, 3), obs: mesma coisa que '(1, 2, 3)
(println (first '(1 2 3))) ;; 1
(println (last '(1 2 3))) ;; 3
(println (rest '(1 2 3))) ;; (2 3)
(println (cons :cons '(1 2 3))) ;; aqui mescla os elementos. (:cons 1 2 3)

;; vetores
(println [:ele1 :ele2 :ele3]) ;; [:ele1 :ele2 :ele3]
(println (first [:ele1 :ele2 :ele3])) ;; :ele1
(println (last [:ele1 :ele2 :ele3])) ;; :ele3
(println (nth [:ele1 :ele2 :ele3] 1)) ;; :ele2
(println ([:ele1 :ele2 :ele3] 2)) ;; :ele3
(println (concat [:ele1] [:ele2])) ;; (:ele1 :ele2) . Mescla criando uma lista
(println (rest [:ele1 :ele2 :ele3])) ;; (:ele2 :ele3)

;; Sets
(def setzin #{:ele1 :ele3 :ele2}) ;; atribuindo um set a uma variavel qualquer
(println setzin) ;; #{:ele1 :ele3 :ele2}
(println (count setzin)) ;; 3
(println (sort setzin)) ;; (:ele1 :ele2 :ele3)
(println (sorted-set 2 3 1)) ;; #{1 2 3}
(println (clojure.set/union #{:ele1} #{:ele2})) ;; #{:ele1 :ele2}
(println (clojure.set/difference #{1 2 3} #{2})) ;; retorna o que é diferente de dois. #{1 3}
(println (setzin :ele1)) ;; :ele1
(println (setzin :ele4)) ;; nil
(println {:um :one :dois :two}) ;; {:um :one, :dois :two}
(def translat {:um :one :dois :two})
(println (translat :um)) ;; one
(println (merge {:um :one} {:dois :two})) ;; {:um :one, :dois :two}
(println (merge-with + {:num1 1} {:num2 5} {:num1 3})); ;; {:num2 5, :num1 4}. somou o 3 com 1
(println (assoc {:um :one} :quatro :four)) ;; {:quatro :four, :um :one}
(println (sorted-map 1 :one 3 :three 2 :two)) ;; {1 :one, 2 :two, 3 :three}

;; Functions
(defn force-it [] (str "uma funcao" " qualquer"))
(println (force-it)) ;; uma funcao qualquer
(defn force-it-with-description
  "Uma descrição qualquer para a função"
  []
  (str "uma funcao" " qualquer")
)
(println (doc force-it-with-description))
;;-------------------------
;;user/force-it-with-description
;;([])
;;  Uma descrição qualquer para a função
;;nil

(defn force-it[parametro] (str "olá " parametro))
(println (force-it "Mundo")) ;; olá Mundo

;; Binding
(def variavel [[1 2][3 4]])
(println variavel) ;; [[1 2][3 4]]
(defn line-end [ln] (last ln)) ;; o ultimo elemento do ln (lista passada pelo parametro)
(println (line-end variavel)) ;; [3 4]
(defn line-end [[[_ _] [second _]]] second) ;;
(println (line-end variavel)) ;; 3
(def board [[:x :o :x] [:o :y :o] [:o :x :o]])
(defn centro [ [_ [_ x _] _] ] x)
(println (centro board)) ;; :y
;; da pra simplificar
(defn centro [[_ [_ x]]] x)
(println (centro board)) ;; :y

(defn center [board] (let [[_ [_ c]] board] c))
(println (centro board)) ;; :y

(def person {:name "Jabba" :profession "Gangster"})
(let [{name :name} person] (str "The person's name is " name)) ;; The person's name is Jabba

;; High-order-functions
(def people ["Lea", "Han Solo"])
(defn contador-ao-dobro [x] (* 2 (count x)))
(println (map contador-ao-dobro people)) ;; (6 16)

;; da pra fazer direto mesmo
(println (map (fn [x] (* 2 (count x))) people)) ;; (6 16)
;; ou assim
(println (map #(* 2 (count %)) people)) ;; (6 16) o % é o item corrente é o igual o [x] de cima

(def v [3 1 2])
(println (apply + v)) ;; 6
(println (apply max v)) ;; 3
(println (filter odd? v)) ;; 1 3
(println (filter #(< % 3) v)) ;; 1 2
