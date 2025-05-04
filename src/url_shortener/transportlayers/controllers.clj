(ns url-shortener.transportlayers.controllers
  (:require [url-shortener.config.dependencies :as cfg]))

(defn string-handler [_]
  {:status 200
   :body "URL shortener"})

(defn shorten-url [{body :body-params}]
  (let [hash-key (cfg/hash-url-and-save (get body :url))]
    {:status 200
     :body {:hash-key hash-key}}))

(defn redirect-to-original [{{:keys [hash-id]} :path-params}]
  (let [original-url (cfg/get-original-url hash-id)]
    {:status 301
     :headers {"Location" original-url}}))