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
  
  (spell 10) => "ten")
