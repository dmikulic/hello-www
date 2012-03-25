(defproject hello-www "1.0.0-SNAPSHOT"
  :description "Simple web app"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [ring/ring-jetty-adapter "1.0.2"]
                 [compojure "1.0.1"]
                 [de.ubercode.clostache/clostache "1.0.0"]]
  :main hello-www.routes)
