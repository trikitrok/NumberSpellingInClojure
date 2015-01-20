(ns number-spelling.core)

(declare 
  one-word-numbers
  num-digits
  pow
  separators)

(defn spell [number]
  (if-let [one-word-number (get one-word-numbers number)]
    one-word-number
    
    (let [num-digits (num-digits number)
          closest-power-of-ten (* (quot number (pow 10 (dec num-digits))) (pow 10 (dec num-digits)))]
          (str (get one-word-numbers closest-power-of-ten)
               (get separators num-digits)
               (spell (- number closest-power-of-ten))))))

(defn- pow [base exp]
  (reduce * (repeat exp base)))

(def ^:private separators
  {2 " "
   3 " and "})

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

