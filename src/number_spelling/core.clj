(ns number-spelling.core)

(defn spell [number]
  (if (zero? number)
    "zero"
    "one"))