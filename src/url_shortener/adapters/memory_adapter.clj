(ns url-shortener.adapters.memory-adapter)

(def urls (atom {}))

(defn get-from-memory
  [key]
  (get @urls key))

(defn set-in-memory
  [key value]
  (swap! urls assoc key value))