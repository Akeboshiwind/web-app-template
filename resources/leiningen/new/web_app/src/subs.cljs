(ns {{name}}.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
 ::bg-color
 (fn [db _]
   (:bg-color db)))

(reg-sub
 ::load-date
 (fn [db _]
   (:load-date db)))
