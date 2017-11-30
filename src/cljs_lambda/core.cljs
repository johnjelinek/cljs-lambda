(ns cljs-lambda.core
  (:require [cljs-lambda.greeter :as greeter]))

(defn ^:export handler
  [event context callback]
  (callback nil greeter/greeting))
