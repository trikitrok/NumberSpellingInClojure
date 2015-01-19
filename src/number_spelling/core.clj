(ns number-spelling.core)

(def ^:private units 
  {0 "zero"
   1 "one"})

(defn spell [number]
  (get units number))