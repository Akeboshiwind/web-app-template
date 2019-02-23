(ns {{name}}.events
  (:require [re-frame.core :as rf :refer [reg-event-db
                                          reg-event-fx
                                          trim-v
                                          inject-cofx]]
            [cljs.spec.alpha :as s]
            [{{name}}.db :as db]
            [{{name}}.effects :as effects]
            [{{name}}.coeffects :as coeffects]
            [day8.re-frame.http-fx]
            [expound.alpha :as expound]
            [ajax.core :as ajax]))

(defn check-and-throw
  "Throws an exception if `db` doesn't match the spec `a-spec`"
  [a-spec db]
  (when-not (s/valid? a-spec db)
    (throw (ex-info (str "spec check failed: " (expound/expound-str a-spec db)) {}))))

(def check-spec-interceptor (rf/after (partial check-and-throw ::db/db)))

(reg-event-fx
 ::initialize-db
 [check-spec-interceptor
  (inject-cofx ::coeffects/now)]
 (fn [cofx _]
   {:db (assoc db/default-db :load-date (:now cofx))
    :dispatch-n []
    ::effects/log "Initialized db :)"}))

(reg-event-fx
 ::set-bg-color
 [check-spec-interceptor
  trim-v]
 (fn [cofx [new-bg-color]]
   {:db (assoc (:db cofx) :bg-color new-bg-color)
    ::effects/log (str ":bg-color set to: " new-bg-color)}))
