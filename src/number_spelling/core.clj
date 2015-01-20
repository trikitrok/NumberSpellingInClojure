(ns number-spelling.core)

(declare 
  one-word-numbers
  num-digits
  pow
  spell-out-number-over-99
  spell-out-number-up-to-99)

(defn spell-out [number]
  (cond 
    (> (num-digits number) 9) (spell-out-number-over-99 number 9 " billion" ", ")
    
    (> (num-digits number) 6) (spell-out-number-over-99 number 6 " million" ", ")
    
    (> (num-digits number) 3) (spell-out-number-over-99 number 3 " thousand" ", ")
    
    (> (num-digits number) 2) (spell-out-number-over-99 number 2 " hundred" " and ")
    
    :else (spell-out-number-up-to-99 number)))

(defn- spell-out-number-over-99 [number digits separator1 separator2]
  (let [power-of-ten (pow 10 digits)
        over-power-of-ten (rem number power-of-ten)]
    (str (spell-out (quot number power-of-ten))
         separator1
         (if (zero? over-power-of-ten) 
           ""
           (str separator2 (spell-out over-power-of-ten))))))

(defn- spell-out-number-up-to-99 [number]
  (if-let [one-word-number (get one-word-numbers number)]
    one-word-number 
    (str (spell-out (* (quot number 10) 10))
         (if (zero? (rem number 10))
           ""
           (str " " (spell-out (rem number 10)))))))

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