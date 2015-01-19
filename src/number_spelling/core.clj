(ns number-spelling.core)

(def ^:private spellings-by-number 
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
   11 "eleven"})

(defn spell [number]
  (get spellings-by-number number))