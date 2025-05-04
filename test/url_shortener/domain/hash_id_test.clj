(ns url-shortener.domain.hash-id-test
  (:require [clojure.test :refer :all]
            [url-shortener.domain.hash-id :as domain]))

(deftest gen-id-test
  (testing "should generate random number between 1 and 350000000"
    (let [random-number (domain/gen-id)]
      (is (>= random-number 0))
      (is (<= random-number 350000000)))))

(deftest hash-id-test
  (testing "should generate base 62 from int number"
    (let [hash-id (domain/hash-id 400870)]
      (is (some? hash-id))
      (is (= hash-id "1GhE")))))