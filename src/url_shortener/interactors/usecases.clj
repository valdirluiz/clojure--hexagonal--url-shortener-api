(ns url-shortener.interactors.usecases
  (:require [url-shortener.domain.hash-id :as hash-domain]))

(defn hash-url-and-save
  [save-to-repo-fn url]
  (let [hash-key (hash-domain/hash-id (hash-domain/gen-id))]
    (save-to-repo-fn hash-key url)
    hash-key))

(defn get-original-url
  [get-from-repo-fn hash-key]
  (get-from-repo-fn hash-key))