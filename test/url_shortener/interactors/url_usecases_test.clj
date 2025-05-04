(ns url-shortener.interactors.url_usecases-test
  (:require [clojure.test :refer :all]
            [url-shortener.interactors.url_usecases :as uc]))

(def mock-urls (atom {}))

(defn get-from-memory-mock
  [key]
  (get @mock-urls key))

(defn set-in-memory-mock
  [key value]
  (swap! mock-urls assoc key value))

(deftest hash-url-and-save-test
  (testing "should generate and save hash-url"
    (let [hash-key (uc/hash-url-and-save set-in-memory-mock "https://google.com")]
      (is (some? hash-key))
      (is (some? (get @mock-urls hash-key))))))