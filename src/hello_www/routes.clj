(ns hello-www.routes
  (:use compojure.core
        [ring.adapter.jetty :only [run-jetty]])
  (:require [compojure.route :as route]
            [compojure.handler :as handler])
  (:use hello-www.views))


(defroutes main-routes
  (GET "/" [] (index-page))

  ;;(GET "/user/uid-:id" [id] (get-id id))  ;;OR using a regular expression checker
  (GET ["/user/uid-:id" :id #"[0-9]+"] [id] (hello-www.views/get-id id))

  (GET "/form/" []     (hello-www.views/user-form)) ;; can be written as a multi-method
  (POST "/form/"[name] (hello-www.views/process-user-form name))

  (route/resources "/static/")
  (route/not-found "Page not found"))


(def app (handler/site main-routes))
(defn -main [];;port
  ;;(run-jetty app {:port (Integer. port)})
  (run-jetty app {:port 8080}))
