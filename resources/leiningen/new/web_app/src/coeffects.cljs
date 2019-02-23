(ns {{name}}.coeffects
  (:require [re-frame.core :refer [reg-cofx]]))

(reg-cofx
 ::now
 (fn [coeffects local-store-key]
   (assoc coeffects :now (js.Date.))))
