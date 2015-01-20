(ns number-spelling.core-test
  (:use midje.sweet)
  (:use [number-spelling.core]))

(facts 
  "about number-spelling"
  
  (fact 
    "it can spell out one-digit numbers" 
    (spell-out 0) => "zero"
    (spell-out 1) => "one"
    (spell-out 9) => "nine")
  
  (fact 
    "it can spell out two-digit numbers" 
    (spell-out 10) => "ten"
    (spell-out 11) => "eleven"
    (spell-out 19) => "nineteen"
    (spell-out 20) => "twenty"
    (spell-out 21) => "twenty one"
    (spell-out 30) => "thirty"
    (spell-out 39) => "thirty nine"
    (spell-out 95) => "ninety five")
  
  (fact 
    "it can spell out three-digit numbers" 
    (spell-out 100) => "one hundred"
    (spell-out 103) => "one hundred and three"
    (spell-out 199) => "one hundred and ninety nine"
    (spell-out 999) => "nine hundred and ninety nine")
  
  (fact
    "it can spell out four-digit numbers"
    (spell-out 1000) => "one thousand"
    (spell-out 1501) => "one thousand, five hundred and one"
    (spell-out 9000) => "nine thousand"
    (spell-out 9999) => "nine thousand, nine hundred and ninety nine")
  
  (fact
    "it can spell out five-digit numbers"
    (spell-out 21501) => "twenty one thousand, five hundred and one"
    (spell-out 99999) => "ninety nine thousand, nine hundred and ninety nine")
  
  (fact
    "it can spell out six-digit numbers"
    (spell-out 999999) => "nine hundred and ninety nine thousand, nine hundred and ninety nine")
  
  (fact
    "it can spell out seven-digit numbers"
    (spell-out 9999999) => "nine million, nine hundred and ninety nine thousand, nine hundred and ninety nine")
  
  (fact
    "it can spell out eight-digit numbers"
    (spell-out 99999999) => "ninety nine million, nine hundred and ninety nine thousand, nine hundred and ninety nine")
  
  (fact
    "it can spell out nine-digit numbers"
    (spell-out 999999999) => "nine hundred and ninety nine million, nine hundred and ninety nine thousand, nine hundred and ninety nine")
  
  (fact
    "it can spell out ten-digit numbers"
    (spell-out 9999999999) => "nine billion, nine hundred and ninety nine million, nine hundred and ninety nine thousand, nine hundred and ninety nine")
  
  (fact
    "it can spell out a lot of billions!"
    (spell-out 9999999999999) => 
    "nine thousand, nine hundred and ninety nine billion, nine hundred and ninety nine million, nine hundred and ninety nine thousand, nine hundred and ninety nine"))
