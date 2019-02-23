(defproject {{name}} "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure       "1.10.0"]
                 [org.clojure/clojurescript "1.10.520"]
                 [expound                   "0.7.2"]
                 [reagent                   "0.8.1"]
                 [re-frame                  "0.10.6"]
                 [cljs-ajax                 "0.8.0"]
                 [day8.re-frame/http-fx     "0.1.6"]]

  :plugins [[lein-cljsbuild "1.1.7"]]

  :source-paths ["src/clj"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :cljsbuild
  {:builds
   [{:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            {{name}}.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}]}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.10"]
                   [com.bhauman/figwheel-main "0.2.0"]
                   [com.bhauman/rebel-readline-cljs "0.1.4"]
                   [cider/piggieback   "0.4.0"]
                   [re-frisk           "0.5.4"]]

    :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}

    :source-paths ["src/cljs"]
    :resource-paths ["target"]}})
