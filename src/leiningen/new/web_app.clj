(ns leiningen.new.web-app
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "web-app"))

(defn web-app
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' web-app project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["dev.cljs.edn" (render "dev.cljs.edn" data)]
             ["figwheel-main.edn" (render "figwheel-main.edn" data)]
             [".gitignore" (render ".gitignore" data)]
             ["README.md" (render "README.md" data)]
             ["src/cljs/{{sanitized}}/core.cljs" (render "src/core.cljs" data)]
             ["src/cljs/{{sanitized}}/config.cljs" (render "src/config.cljs" data)]
             ["src/cljs/{{sanitized}}/views.cljs" (render "src/views.cljs" data)]
             ["src/cljs/{{sanitized}}/events.cljs" (render "src/events.cljs" data)]
             ["src/cljs/{{sanitized}}/subs.cljs" (render "src/subs.cljs" data)]
             ["src/cljs/{{sanitized}}/db.cljs" (render "src/db.cljs" data)]
             ["src/cljs/{{sanitized}}/effects.cljs" (render "src/effects.cljs" data)]
             ["src/cljs/{{sanitized}}/coeffects.cljs" (render "src/coeffects.cljs" data)]
             ["resources/public/index.html" (render "resources/index.html" data)]
             ["resources/public/css/styles.css" (render "resources/css/styles.css" data)])))
