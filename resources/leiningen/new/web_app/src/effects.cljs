(ns {{name}}.effects
  (:require [re-frame.core :refer [reg-fx]]))

(reg-fx
 ::log
 (fn [message]
   (.log js/console message)))
