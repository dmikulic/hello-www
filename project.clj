(defproject hello-www "1.0.0"
  :description "Simple web app"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [ring/ring-jetty-adapter "1.1.0"]
                 [compojure "1.0.3"]
                 [de.ubercode.clostache/clostache "1.3.0"]]
  :main hello-www.routes)
