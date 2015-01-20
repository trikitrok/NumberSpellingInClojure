(ns number-spelling.core)

(declare 
  one-word-numbers
  num-digits
  pow)

(defn spell [number]
  (if-let [one-word-number (get one-word-numbers number)]
    one-word-number
    (case (num-digits number)
      
      2 (let [closest-ten-multiple (* (quot number (pow 10 (dec 2))) (pow 10 (dec 2)))]
          (str (get one-word-numbers closest-ten-multiple)
               " "
               (get one-word-numbers (- number closest-ten-multiple))))
      
      3 (let [closest-hundred-multiple (* (quot number (pow 10 (dec 3))) (pow 10 (dec 3)))]
          (str (get one-word-numbers closest-hundred-multiple)
               " and "
               (get one-word-numbers (- number closest-hundred-multiple)))))))

(defn- pow [base exp]
  (reduce * (repeat exp base)))

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
   30 "thirty"
   40 "forty"
   50 "fifty"
   60 "sixty"
   70 "seventy"
   80 "eighty"
   90 "ninety"
   100 "one hundred"})

(defn- num-digits [number]
  (count (str number)))

