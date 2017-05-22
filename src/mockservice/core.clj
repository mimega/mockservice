(ns mockservice.core
  (:gen-class)
  (:require [clojure.core.async
             :as a
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout]])
  (:use org.httpkit.server
        (compojure [core :only [defroutes GET POST]]
                   [handler :only [site]]
                   [route :only [files not-found]])))

(defn async-response [request]
  (with-channel request channel
      (go (send! channel {:status 200 :body "dummy"}))))

(defroutes routes
  (GET "/test" [] async-response)
  (not-found "<p>Page not found.</p>" ))

(defn -main [& args]
  (let [port (-> args first Integer/parseInt)]
    (run-server (-> #'routes site) {:port port})
    (println "clojure.core.async.pool-size=" (System/getProperty "clojure.core.async.pool-size"))
    (println "server started. http://127.0.0.1:" port)))
