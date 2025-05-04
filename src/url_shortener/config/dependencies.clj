(ns url-shortener.config.dependencies
  (:require [url-shortener.interactors.url_usecases :as use-cases]
            [url-shortener.adapters.memory-adapter :as adapter]))

(defn hash-url-and-save
  [url]
  (use-cases/hash-url-and-save adapter/set-in-memory url))

(defn get-original-url
  [url]
  (use-cases/get-original-url adapter/get-from-memory url))