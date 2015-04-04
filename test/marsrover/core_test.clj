(ns marsrover.core-test
  (:require [expectations :refer :all]
            [marsrover.core :refer :all]))

(expect [:north [0 0]] (rover-exec-str-commands [:north [0 0]] ""))
(expect [:east [0 0]] (rover-exec-str-commands [:east [0 0]] ""))
(expect [:north [0 1]] (rover-exec-str-commands [:north [0 0]] "f"))
(expect [:north [0 0]] (rover-exec-str-commands [:north [0 0]] ""))
(expect [:north [0 2]] (rover-exec-str-commands [:north [0 0]] "ff"))
(expect [:north [0 -1]] (rover-exec-str-commands [:north [0 0]] "b"))
(expect [:north [0 -2]] (rover-exec-str-commands [:north [0 0]] "bb"))
(expect [:east [1 0]] (rover-exec-str-commands [:east [0 0]] "f"))

(expect [:east [0 0]] (rover-exec-str-commands [:north [0 0]] "r"))
(expect [:west [0 0]] (rover-exec-str-commands [:north [0 0]] "l"))

(expect [:north [1 0]] (rover-exec-str-commands [:north [1 0]] "frfrfrfr"))
