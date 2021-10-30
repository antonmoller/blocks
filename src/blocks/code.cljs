(ns blocks.code
  (:require
   [cljs.js :as cljs]
   [cljs.env :as env]
   [shadow.cljs.bootstrap.browser :as boot]
   [blocks.constants :refer [compile-state-ref]]))


(defn print-result [{:keys [error value] :as result}]
  (js/console.log "result" result)
  (js/console.log value))

(defn compile-it [code]
  (cljs/eval-str
   compile-state-ref
   code
   "[blocks]"
   {:eval cljs/js-eval
    :load (partial boot/load compile-state-ref)}
   print-result))