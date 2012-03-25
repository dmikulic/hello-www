(ns hello-www.views
  (:use clostache.parser))


(defn render-to-response [template values]
  (render (slurp (str "resources/templates/" template)) values))

(defn index-page []
  (render-to-response "index.html" {:var "Hello, world!"}))

(defn get-id [id]
  (render-to-response "index.html" {:var (str "Hello: " id)}))

(defn user-form []
  (render-to-response "form.html" {}))

(defn process-user-form [name]
  (render-to-response "index.html" {:var (str "Thanks " name)}))
