(ns number-spelling.core)

(declare 
  one-word-numbers
  num-digits
  pow
  number-spelling)

(defn spell-out [number]
  (if-let [one-word-number (get one-word-numbers number)]
    one-word-number
    (let [num-digits (num-digits number)]
      (cond 
        (> num-digits 9) 
          (number-spelling number 1 9 " billion" ", ")
        
        (> num-digits 6) 
          (number-spelling number 1 6 " million" ", ")
        
        (> num-digits 3) 
          (number-spelling number 1 3 " thousand" ", ")
        
        (> num-digits 2) 
          (number-spelling number 1 2 " hundred" " and ")
        
        :else 
          (number-spelling number 10 1 "" " ")))))

(defn- number-spelling [number factor exp separator1 separator2]
  (let [power-of-ten (pow 10 exp)
        close-number (* factor (quot number power-of-ten))
        rest-of-number (rem number power-of-ten)]
    (str (spell-out close-number)
         separator1
         (when-not (zero? rest-of-number) 
           (str separator2 (spell-out rest-of-number))))))

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
   90 "ninety"})

(defn- num-digits [number]
  (count (str number)))