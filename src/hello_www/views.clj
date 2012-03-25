(ns hello-www.views
  (:use clostache.parser))

(defn render-to-response
  ([template] (render (slurp (str "resources/templates/" template)) {}))
  ([template values] (render (slurp (str "resources/templates/" template)) values)))

;; VIEWS

(defn index-page []
  (render-to-response "index.html" {:var "Hello, world!"}))

(defn get-id [id]
  (render-to-response "index.html" {:var (str "User ID: " id)}))

(defn user-form
  ([]     (render-to-response "form.html"))
  ([name] (render-to-response "index.html" {:var (str "Hello, " name)})))
