(ns blocks.components.editor
  (:require
   [shadow.cljs.bootstrap.browser :as boot]
   [cljs.js :as cljs]
   [cljs.env :as env]
   ["@monaco-editor/react" :default MonacoEditor]))

(defonce compile-state-ref (env/default-compiler-env))

;; (def code "(println \"hi there\")")
;;    ;; Enter your ClojureScript code
(def code
  "(ns hello-world-example.core
   (:require [reagent.dom :as rdom]))

(defn app []
  [:h1 {:style {:color \"green\"}} \"Hello World!\"])

(rdom/render [app] (.getElementById js/document \"visual\"))")

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

(defn editor []
  (boot/init compile-state-ref {:path "/bootstrap"} #(js/console.log "eval ready"))
  (let [handle-change (fn [value _]
                        (compile-it value))]
    [:div {:style {:display "flex" :flex-direction "column" :width "700px"}}
    ;; [:h1 "Data Editor"] 
    ;; [:h1 "Visual Editor"] 
     [:> MonacoEditor
      {;:height "35vh"
       :defaultValue code
       :defaultLanguage "clojure"
       :theme "light"
       :onChange handle-change
    ;;   :onBlur (fn [value _] (js/console.log value))
       :options {:minimap {:enabled false}
                 :folder false
                 :showUnused false
                 :lineNumberMinChars 3
                 :tabSize 2
                 :scrollBeyondLastLine false
                 :automaticLayout true}}]]))