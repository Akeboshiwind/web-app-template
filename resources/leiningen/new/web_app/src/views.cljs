(ns {{name}}.views
  (:require [re-frame.core :refer [subscribe dispatch]]
            [{{name}}.subs :as subs]
            [{{name}}.events :as events]))

(defn main-panel
  []
  (let [bg-color (subscribe [::subs/bg-color])
        load-date (subscribe [::subs/load-date])]
    (fn []
      [:div
       [:h1 "My Colour Tester"]
       [:div
        {:style {:background-color @bg-color
                 :width 100
                 :height 100}}]
       [:input {:type "text"
                :value @bg-color
                :on-change #(dispatch [::events/set-bg-color (-> % .-target .-value)])}]
       [:div
        (str "Loaded at: " @load-date)]])))
