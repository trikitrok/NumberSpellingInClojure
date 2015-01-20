(ns number-spelling.core-test
  (:use midje.sweet)
  (:use [number-spelling.core]))

(facts 
  "about number-spelling"
  
  (fact 
    "it can spell one-digit numbers" 
    (spell 0) => "zero"
    (spell 1) => "one"
    (spell 9) => "nine")
  
  (fact 
    "it can spell two-digit numbers" 
    (spell 10) => "ten"
    (spell 11) => "eleven"
    (spell 19) => "nineteen"
    (spell 20) => "twenty"
    (spell 21) => "twenty one"
    (spell 30) => "thirty"
    (spell 39) => "thirty nine"
    (spell 95) => "ninety five")
  
  (fact 
    "it can spell three-digit numbers" 
    (spell 100) => "one hundred"
    (spell 103) => "one hundred and three"
    (spell 199) => "one hundred and ninety nine"
    (spell 999) => "nine hundred and ninety nine")
  
  (fact
    "it can spell four-digit numbers"
    (spell 1501) => "one thousand, five hundred and one"
    (spell 9999) => "nine thousand, nine hundred and ninety nine")
  
  (fact
    "it can spell five-digit numbers"
    (spell 21501) => "twenty one thousand, five hundred and one"
    (spell 99999) => "ninety nine thousand, nine hundred and ninety nine")
  
  (fact
    "it can spell five-digit numbers"
    (spell 999999) => "nine hundred and ninety nine thousand, nine hundred and ninety nine"))
