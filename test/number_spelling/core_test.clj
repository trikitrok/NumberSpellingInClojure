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
    "it can spell two-digit numbers until 19" 
    (spell 10) => "ten"
    (spell 11) => "eleven"
    (spell 19) => "nineteen")
  
  (spell 20) => "twenty"
  (spell 21) => "twenty one"
  (spell 30) => "thirty"
  (spell 39) => "thirty nine")
