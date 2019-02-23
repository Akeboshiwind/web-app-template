(ns {{name}}.db
  (:require [cljs.spec.alpha :as s]))

(s/def ::bg-color string?)
(s/def ::load-date (s/or :nil nil?
                         :not (complement nil?)))

(s/def ::db (s/keys :req-un [::bg-color
                             ::load-date]))

(def default-db
  {:bg-color "blue"
   :load-date nil})
