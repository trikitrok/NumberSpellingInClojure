(ns number-spelling.core)

(def ^:private one-word-numbers 
  {0 "zero"
   1 "one"
   2 "two"
   3 "three"
   4 "four"
   5 "five"
   6 "six"
   7 "seven"
   8 "eight"
   9 "nine"
   10 "ten"
   11 "eleven"
   12 "twelve"
   13 "thirteen"
   14 "fourteen"
   15 "fifteen"
   16 "sixteen"
   17 "seventeen"
   18 "eightteen"
   19 "nineteen"
   20 "twenty"
   30 "thirty"})

(defn spell [number]
  (if-let [one-word-number (get one-word-numbers number)]
    one-word-number
    (let [closest-ten-multiple (* (quot number 10) 10)]
      (str (get one-word-numbers closest-ten-multiple)
           " "
           (get one-word-numbers (- number closest-ten-multiple))))))

