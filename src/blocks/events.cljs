(ns blocks.events
  (:require
   [re-frame.core :as re-frame]
   [blocks.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))

(re-frame/reg-event-fx
 ::hello-world
 (fn []
   (js/console.log "HELLO WORLD")))