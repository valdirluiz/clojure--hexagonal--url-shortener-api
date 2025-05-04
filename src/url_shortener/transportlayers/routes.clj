(ns url-shortener.transportlayers.routes
  (:require [reitit.ring :as ring]
            [muuntaja.core :as m]
            [reitit.ring.middleware.muuntaja :as muuntaja]
            [url-shortener.transportlayers.controllers :as controllers]))

(def app
  (ring/ring-handler
    (ring/router
      ["/"
       ["shorten" {:post controllers/shorten-url}]
       ["go/:hash-id" {:get controllers/redirect-to-original}]
       ["" {:get controllers/string-handler}]]
      {:data {:muuntaja m/instance
              :middleware [muuntaja/format-middleware]}})))