(ns marsrover.core)

(defprotocol ToArray
  (toArray[o])
)

(defprotocol Move)

(defrecord Rover[direction point]
  Object
  (toString[this]
    (str (:point this) " " direction))
  ToArray
  (toArray[this]
    [(:direction this) (:point this)])
)

(def directions-right {:north :east
                       :east :south
                       :south :west
                       :west :north})

(def directions-left {:north :west
                      :west :south
                      :south :east
                      :east :north})

(def directions-vectors {:north [0 1]
                         :east [1 0]
                         :south [0 -1]
                         :west [-1 0]})

(defn op-point [op p1 p2]
  (let [[x1 y1] p1 [x2 y2] p2]
    [(op x1 x2) (op y1 y2)]
    ))

(defn rover-exec-command [position char-command]
  (let [[d point] position]
    (case char-command
      \f [d (op-point + point (directions-vectors d))]
      \b [d (op-point - point (directions-vectors d))]
      \r [(directions-right d) point]
      \l [(directions-left d) point])))

(defn rover-exec-char-commands [position char-commands]
  (if (nil? char-commands)
    position
    (let [[x & xs] char-commands]
      (rover-exec-char-commands
       (rover-exec-command position x)
       xs))))

(defn rover-exec-str-commands [position str-commands]
  (rover-exec-char-commands position (seq str-commands)))

(defn hola []
  (println "hola - adeu - ups"))
