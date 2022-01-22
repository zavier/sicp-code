(ns sicp-code.sqrt)

(defn average [x y]
  (/ (+ x y) 2))

(defn square [x] (* x x))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn good-enough? [guess x]
  (< (Math/abs (- (square guess) x)) 0.001))

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (recur (improve guess x) x)))

(defn sqrt [x]
  "计费平方根"
  (sqrt-iter 1.0 x))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (sqrt 1000) (factorial 4)))