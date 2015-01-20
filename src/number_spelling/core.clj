(ns number-spelling.core)

(declare 
  one-word-numbers
  num-digits
  pow
  separators
  closest-power-of-ten
  postfixes)

(defn spell [number]
  (if-let [one-word-number (get one-word-numbers number)]
    one-word-number
    
    (let [num-digits (num-digits number)
          multiple-of-closest-power-of-ten (quot number (pow 10 (dec num-digits)))
          closest-power-of-ten (closest-power-of-ten number num-digits)
          num-minus-closest-power-of-ten (- number closest-power-of-ten)]
      
      (str 
        (if-let [one-word-number (get one-word-numbers closest-power-of-ten)]
          one-word-number
          (spell multiple-of-closest-power-of-ten))
        
        (get postfixes num-digits)
        
        (if (zero? num-minus-closest-power-of-ten)
          ""
          (str
            (get separators num-digits) 
            (spell num-minus-closest-power-of-ten)))))))

(defn- closest-power-of-ten [number num-digits]
  (* (quot number (pow 10 (dec num-digits))) 
     (pow 10 (dec num-digits))))

(def ^:private postfixes
  {1 ""
   2 ""
   3 " hundred"})

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
   90 "ninety"})

(defn- num-digits [number]
  (count (str number)))

