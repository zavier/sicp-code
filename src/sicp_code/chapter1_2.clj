(ns sicp-code.chapter1_2)

(defn first-denomination [kinds-of-coins]
  (cond
    (= 1 kinds-of-coins) 1
    (= 2 kinds-of-coins) 5
    (= 3 kinds-of-coins) 10
    (= 4 kinds-of-coins) 25
    (= 5 kinds-of-coins) 50))

(defn cc [amount kinds-of-coins]
  (cond
    (= amount 0) 1
    (or (< amount 0) (= kinds-of-coins 0)) 0
    :else (+ (cc amount (- kinds-of-coins 1))
             (cc (- amount (first-denomination kinds-of-coins)) kinds-of-coins))))

;; 换硬币方式种数：将总数除第一种硬币之外其他所有硬币的不同方式 + 总数-第一种硬币面额 后 换成所有硬币不同方式的种数
(defn count-change [amount]
  "换硬币（使用1美分，5美分，10美分，25美分，50美分），有多少种方式"
  (cc amount 5))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (count-change 100)))
