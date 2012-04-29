(ns hello-www.routes
  (:use compojure.core
        hello-www.views
        [ring.adapter.jetty :only [run-jetty]])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]))


(defroutes main-routes
  (GET "/" [] (hello-www.views/index-page))

  ;;(GET "/user/uid-:id" [id] (get-id id))
  (GET ["/user/uid-:id" :id #"[0-9]+"] [id] (hello-www.views/get-id id))

  (GET "/form/" []     (hello-www.views/user-form))
  (POST "/form/"[name] (hello-www.views/user-form name))

  (route/resources "/static/")
  (route/not-found "Page not found"))


(def app (handler/site main-routes))
(defn -main []
  ;;(run-jetty app {:port (Integer. port)})
  (run-jetty app {:port 8080}))
