(ns blocks.constants
  (:require
   [cljs.env :as env]))

(defonce compile-state-ref (env/default-compiler-env))